package AutoWithAll.AutoWithAll.controllers;

import AutoWithAll.AutoWithAll.models.Advertisement;
import AutoWithAll.AutoWithAll.models.IPlan;
import AutoWithAll.AutoWithAll.models.User;
import AutoWithAll.AutoWithAll.payload.request.IPlanRequest;
import AutoWithAll.AutoWithAll.repository.AdRepository;
import AutoWithAll.AutoWithAll.repository.IPlanRepository;
import AutoWithAll.AutoWithAll.repository.UserRepository;
import AutoWithAll.AutoWithAll.security.services.IPlanDetailsImpl;
import AutoWithAll.AutoWithAll.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

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

    public IPlan iPlanPost(@RequestBody IPlanRequest iPlanRequest , Authentication authentication){
        UserDetailsImpl userDetails=(UserDetailsImpl) authentication.getPrincipal();
        User user = userRepository.findById(userDetails.getId()).get();
        Advertisement advertisement = adRepository.findById(iPlanRequest.getAd_id()).get();
        IPlan iPlan = new IPlan(

                 iPlanRequest.getPlan_amt(),
                 iPlanRequest.getNo_of_installments(),
                 iPlanRequest.getInterest(),
                 iPlanRequest.getInst_amt(),
                 iPlanRequest.getDescription(),
                 user,
                 advertisement


        );
        return iPlanDetails.saveIPlanDetails(iPlan);
    }
}
