package AutoWithAll.AutoWithAll.controllers;

import AutoWithAll.AutoWithAll.models.ERole;
import AutoWithAll.AutoWithAll.models.Role;
import AutoWithAll.AutoWithAll.models.User;
import AutoWithAll.AutoWithAll.payload.request.LoginRequest;
import AutoWithAll.AutoWithAll.payload.request.SignupRequest;
import AutoWithAll.AutoWithAll.payload.response.JwtResponse;
import AutoWithAll.AutoWithAll.payload.response.MessageResponse;
import AutoWithAll.AutoWithAll.repository.RoleRepository;
import AutoWithAll.AutoWithAll.repository.UserRepository;
import AutoWithAll.AutoWithAll.security.jwt.AuthEntryPointJwt;
import AutoWithAll.AutoWithAll.security.jwt.JwtUtils;
import AutoWithAll.AutoWithAll.security.services.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@CrossOrigin(origins = "*" ,allowedHeaders = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);


    @PostMapping("/signin")
    public ResponseEntity<?>authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
        logger.info("Request /signin");

        logger.info("Username: "+loginRequest.getUsername()+"\t Password: "+loginRequest.getPassword());

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.genarateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl)authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item->item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getFname(),
                userDetails.getLname(),
                userDetails.getTnumber(),
                userDetails.getUsername(),
                userDetails.getNic(),
                userDetails.getDate(),
                roles));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/signup")
    public  ResponseEntity<?>registerUSer(@Valid @RequestBody SignupRequest signupRequest){
        if(userRepository.existsByUsername(signupRequest.getUsername())){
            return  ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }
        if(userRepository.existsByNic(signupRequest.getNic())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: NIC is Already use!"));
        }
        // Create new user's account
        Date date = new Date();

        User user = new User(
                signupRequest.getFname(),
                signupRequest.getLname(),
                signupRequest.getTnumber(),
                signupRequest.getNic(),
                signupRequest.getUsername(),
                encoder.encode(signupRequest.getPassword()),
                date
        );

        Set<String> strRoles = signupRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if(strRoles == null){
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(()->new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        }else {
            strRoles.forEach(role -> {
                switch (role){
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(()->new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;

                    case "agent":
                        Role agentRole = roleRepository.findByName(ERole.ROLE_AGENT)
                                .orElseThrow(()->new RuntimeException("Error: Role is not found."));
                        roles.add(agentRole);

                        break;

                    case "lcompany":
                        Role lcompanyRole = roleRepository.findByName(ERole.ROLE_LCOMPANY)
                                .orElseThrow(()->new RuntimeException("Error: Role is not found."));
                        roles.add(lcompanyRole);

                        break;

                    case "icompany":
                        Role icompanyRole = roleRepository.findByName(ERole.ROLE_ICOMPANY)
                                .orElseThrow(()->new RuntimeException("Error: Role is not found."));
                        roles.add(icompanyRole);

                        break;

                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(()->new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);

                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered sucessfully!"));
    }
}
