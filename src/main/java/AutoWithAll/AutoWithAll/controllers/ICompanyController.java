package AutoWithAll.AutoWithAll.controllers;

import AutoWithAll.AutoWithAll.models.Advertisement;
import AutoWithAll.AutoWithAll.models.IPlan;
import AutoWithAll.AutoWithAll.models.User;
import AutoWithAll.AutoWithAll.payload.request.IPlanRequest;
import AutoWithAll.AutoWithAll.payload.response.MessageResponse;
import AutoWithAll.AutoWithAll.repository.AdRepository;
import AutoWithAll.AutoWithAll.repository.IPlanRepository;
import AutoWithAll.AutoWithAll.repository.UserRepository;
import AutoWithAll.AutoWithAll.security.services.IPlanDetailsImpl;
import AutoWithAll.AutoWithAll.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/icompany")

public class ICompanyController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    IPlanRepository iPlanRepository;

    @Autowired
    IPlanDetailsImpl iPlanDetails;

    @Autowired
    AdRepository adRepository;

    @PostMapping("/postiplan")
    @PreAuthorize("hasRole('ROLE_ICOMPANY')")

    public ResponseEntity<?> iPlanPost(@RequestBody IPlanRequest iPlanRequest , Authentication authentication){
        UserDetailsImpl userDetails=(UserDetailsImpl) authentication.getPrincipal();
        User user = userRepository.findById(userDetails.getId()).get();
        Advertisement advertisement = adRepository.findById(iPlanRequest.getAdId()).get();
        if(adRepository.existsById(iPlanRequest.getAdId())){
        IPlan iPlan = new IPlan(
                iPlanRequest.getPlanAmt(),
                 iPlanRequest.getNoOfInstallments(),
                 iPlanRequest.getInterest(),
                 iPlanRequest.getInstAmt(),
                 iPlanRequest.getDescription(),
                 user,
                 advertisement
        );
         iPlanDetails.saveIPlanDetails(iPlan);
            return ResponseEntity.ok(new MessageResponse("Plan Add sucessfully!"));
        }else {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Invalid Advertisment Id!"));
        }
    }

//    @GetMapping("/getlplanaddad")
//    @PreAuthorize("hasRole('ROLE_ICOMPANY')")
//    public List<Advertisement> getad(Authentication authentication){
//        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//        User user = userRepository.findById(userDetails.getId()).get();
//        return iPlanRepository.findAllByUserAndAdvertisement(user);
//    }
}
