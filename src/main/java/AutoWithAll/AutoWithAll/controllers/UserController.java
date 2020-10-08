package AutoWithAll.AutoWithAll.controllers;

import AutoWithAll.AutoWithAll.models.User;
import AutoWithAll.AutoWithAll.payload.request.SignupRequest;
import AutoWithAll.AutoWithAll.payload.response.MessageResponse;
import AutoWithAll.AutoWithAll.repository.UserRepository;
import AutoWithAll.AutoWithAll.security.services.NormalUserImpl;
import AutoWithAll.AutoWithAll.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

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

    @Value("${upload.location}")
    private String fileLocation;

@GetMapping("/getallusers")
@PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<User>getAllUsers(){
    return userRepository.findAll();
}

@PutMapping("/editprofile")
@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_LCOMPANY') or hasRole('ROLE_ICOMPANY') or hasRole('ROLE_ADMIN') or hasRole('ROLE_AGENT')")
public ResponseEntity<?> editNormalUserEditProfile(@RequestBody SignupRequest signupRequest, Authentication authentication){
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    User user = userRepository.findById(userDetails.getId()).get();

        user.setFname(signupRequest.getFname());
        user.setLname(signupRequest.getLname());
        user.setTnumber(signupRequest.getTnumber());
        user.setAddress(signupRequest.getAddress());
        normalUser.editNormalUserEditProfile(user);
        return ResponseEntity.ok(new MessageResponse("Account update  successfully!"));

}

    @PutMapping("/changepassword/{password}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_LCOMPANY') or hasRole('ROLE_ICOMPANY') or hasRole('ROLE_ADMIN') or hasRole('ROLE_AGENT')")
    public ResponseEntity<?> editPasswordProfile(@RequestBody SignupRequest signupRequest, @PathVariable String password , Authentication authentication){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userRepository.findById(userDetails.getId()).get();
        System.out.println(password);
        if(encoder.matches(password, (user.getPassword()))){
            System.out.println("match");

            System.out.println(encoder.encode(signupRequest.getPassword()));

            user.setPassword(encoder.encode(signupRequest.getPassword()));
            normalUser.editNormalUserEditProfile(user);
            return ResponseEntity.ok(new MessageResponse("Password Change  successfully!"));
        }
        else {

            return  ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Password didn't match!"));
        }
    }

    @PutMapping("/changephoto")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_LCOMPANY') or hasRole('ROLE_ICOMPANY') or hasRole('ROLE_ADMIN') or hasRole('ROLE_AGENT')")
    public ResponseEntity<?> changeProfilePic(@RequestBody String image, Authentication authentication){


        byte[] imageofwrite = Base64.getDecoder().decode(image.split(",")[1]);
        String imgId = UUID.randomUUID().toString();
//        String imgId = "1";

        try (FileOutputStream fos = new FileOutputStream(fileLocation + "/" + imgId)) {
            fos.write(imageofwrite);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userRepository.findById(userDetails.getId()).get();

        user.setImgId(imgId);
        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("Account update  successfully!"));

    }

    @GetMapping("/currentuser")
    public User getCurrentUser( Authentication authentication){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return  userRepository.findById(userDetails.getId()).get();
    }



}
