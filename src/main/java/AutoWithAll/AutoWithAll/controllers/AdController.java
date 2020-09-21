package AutoWithAll.AutoWithAll.controllers;

import AutoWithAll.AutoWithAll.models.Advertisement;
import AutoWithAll.AutoWithAll.models.User;
import AutoWithAll.AutoWithAll.payload.request.AdRequest;
import AutoWithAll.AutoWithAll.repository.UserRepository;
import AutoWithAll.AutoWithAll.security.services.AdDetailsImpl;
import AutoWithAll.AutoWithAll.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/advertisement")
public class AdController {

    @Autowired
    AdDetailsImpl adDetails;

    @Autowired
    UserRepository userRepository;


    @PostMapping("/postadd")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_AGENT')")
    public Advertisement AddPost(@RequestBody AdRequest adRequest, Authentication authentication){
        UserDetailsImpl userDetails=(UserDetailsImpl) authentication.getPrincipal();
        User user=userRepository.findById(userDetails.getId()).get();
        Advertisement advertisement = new Advertisement(
                adRequest.getName(),
                adRequest.getT_number(),
                adRequest.getEmail(),
                adRequest.getLocation(),
                adRequest.getTitle(),
                adRequest.getPrice(),
                adRequest.getV_type(),
                adRequest.getManufacturer(),
                adRequest.getModel(),
                adRequest.getV_condition(),
                adRequest.getM_year(),
                adRequest.getR_year(),
                adRequest.getMileage(),
                adRequest.getE_capacity(),
                adRequest.getTransmission(),
                adRequest.getFuel_type(),
                adRequest.getColour(),
                adRequest.getDescription(),
                user
        );
        //return  userDetails.getUsername();
        return adDetails.saveAdDetails(advertisement);
    }


//    @GetMapping("/")
//    public String index(){
//        return "Fucking hell";
//    }

}
