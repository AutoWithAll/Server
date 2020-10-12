//package AutoWithAll.AutoWithAll.controllers;
//import AutoWithAll.AutoWithAll.models.User;
//import AutoWithAll.AutoWithAll.payload.request.SignupRequest;
//import AutoWithAll.AutoWithAll.payload.response.MessageResponse;
//import AutoWithAll.AutoWithAll.repository.UserRepository;
//import AutoWithAll.AutoWithAll.security.services.AdminDetailsImpl;
//import AutoWithAll.AutoWithAll.security.services.UserDetailsImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//import java.util.Date;
//
//@CrossOrigin(origins = "*",maxAge = 3600)
//@RestController
//@RequestMapping("/admin")
//
//public class AdminController {
//    @Autowired
//    PasswordEncoder encoder;
//    @Autowired
//    UserRepository userRepository;
//    @Autowired
//    AdminDetailsImpl adminDetails;
//
//    @PutMapping("/editprofile")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    public ResponseEntity<?> EditAdminProfile(@RequestBody SignupRequest signupRequest,Authentication authentication){
//        UserDetailsImpl userDetails=(UserDetailsImpl)authentication.getPrincipal();
//        User user =userRepository.findById(userDetails.getId()).get();
//        if(encoder.matches(signupRequest.getPassword(),(user.getPassword()))){
//            user.setFname(signupRequest.getFname());
//            user.setLname(signupRequest.getLname());
//            user.setTnumber(signupRequest.getTnumber());
//            user.setPassword(encoder.encode(signupRequest.getPassword()));
//            adminDetails.editAdminDetails(user);
//            return ResponseEntity.ok(new MessageResponse("Accountupdate successfully!"));
//
//        }
//        return ResponseEntity.badRequest().body(new MessageResponse("Error:Password didn't match!"));
//    }
//}
