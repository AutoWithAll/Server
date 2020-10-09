package AutoWithAll.AutoWithAll.controllers;

import AutoWithAll.AutoWithAll.models.User;
import AutoWithAll.AutoWithAll.repository.UserRepository;
import AutoWithAll.AutoWithAll.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;
@GetMapping("/getallusers")
@PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<User>getAllUsers(){
    return userRepository.findAll();
}
}
