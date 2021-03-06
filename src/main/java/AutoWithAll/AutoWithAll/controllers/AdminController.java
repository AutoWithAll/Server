package AutoWithAll.AutoWithAll.controllers;
import AutoWithAll.AutoWithAll.models.Advertisement;
import AutoWithAll.AutoWithAll.models.ERole;
import AutoWithAll.AutoWithAll.models.Role;
import AutoWithAll.AutoWithAll.models.User;
import AutoWithAll.AutoWithAll.payload.response.MessageResponse;
import AutoWithAll.AutoWithAll.repository.AdRepository;
import AutoWithAll.AutoWithAll.repository.RoleRepository;
import AutoWithAll.AutoWithAll.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/admin")

public class AdminController {

    @Autowired
    AdRepository adRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;


    @PutMapping("/confrim/{adId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?>confrimAd(@PathVariable Long adId){
        Advertisement advertisement = adRepository.findById(adId).get();
        if(advertisement.getFalg() == 0){
            advertisement.setFalg(1);
            adRepository.save(advertisement);
            return ResponseEntity.ok(new MessageResponse("Advertisement Add sucessfully!"));
        }else {
            return  ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Already Add Advertisement!"));
        }
    }

    @GetMapping("/getallagents")
    public List<User> getAgentsWithRole(){
        Role role=roleRepository.findByName(ERole.ROLE_AGENT).get();
        return userRepository.findAllByRolesContaining(role);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/getallusers")
    public List<User> getUsersWithRole(){
        Role role=roleRepository.findByName(ERole.ROLE_USER).get();
        return userRepository.findAllByRolesContaining(role);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/getalllcompany")
    public List<User> getLCompanyWithRole(){
        Role role=roleRepository.findByName(ERole.ROLE_LCOMPANY).get();
        return userRepository.findAllByRolesContaining(role);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/getallicompany")
    public List<User> getICompanyWithRole(){
        Role role=roleRepository.findByName(ERole.ROLE_ICOMPANY).get();
        return userRepository.findAllByRolesContaining(role);
    }


}
