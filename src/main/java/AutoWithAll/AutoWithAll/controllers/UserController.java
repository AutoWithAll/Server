package AutoWithAll.AutoWithAll.controllers;

import AutoWithAll.AutoWithAll.models.User;
import AutoWithAll.AutoWithAll.payload.request.SignupRequest;
import AutoWithAll.AutoWithAll.payload.response.MessageResponse;
import AutoWithAll.AutoWithAll.repository.UserRepository;
import AutoWithAll.AutoWithAll.security.services.NormalUserImpl;
import AutoWithAll.AutoWithAll.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    NormalUserImpl normalUser;
@GetMapping("/getallusers")
@PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<User>getAllUsers(){
    return userRepository.findAll();
}

@PutMapping("/editprofile")
@PreAuthorize("hasRole('ROLE_USER')")
public ResponseEntity<?> editNormalUserEditProfile(@RequestBody SignupRequest signupRequest, Authentication authentication){
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    User user = userRepository.findById(userDetails.getId()).get();
    if(encoder.matches(signupRequest.getPassword(), (user.getPassword()))){
        user.setFname(signupRequest.getFname());
        user.setLname(signupRequest.getLname());
        user.setTnumber(signupRequest.getTnumber());
        user.setPassword(encoder.encode(signupRequest.getPassword()));
        normalUser.editNormalUserEditProfile(user);
        return ResponseEntity.ok(new MessageResponse("Account update sucessfully!"));
    }
    return  ResponseEntity
            .badRequest()
            .body(new MessageResponse("Error: Password didn't match!"));
}

//    @GetMapping("/viewcompany/{role}")
//    public ResponseEntity<?> viewcompany(@RequestBody SignupRequest signupRequest,@PathVariable String[] role, Authentication authentication){
//        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//        User user = userRepository.findById(userDetails.getId()).get();
//        return userRepository.FilterByRole(role);
//    }
}
