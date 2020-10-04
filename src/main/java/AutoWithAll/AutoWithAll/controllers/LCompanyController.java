package AutoWithAll.AutoWithAll.controllers;

import AutoWithAll.AutoWithAll.models.LPlan;
import AutoWithAll.AutoWithAll.models.User;
import AutoWithAll.AutoWithAll.payload.request.LPlanRequest;
import AutoWithAll.AutoWithAll.repository.LPlanRepository;
import AutoWithAll.AutoWithAll.repository.UserRepository;
import AutoWithAll.AutoWithAll.security.services.LPlanDetailsImpl;
import AutoWithAll.AutoWithAll.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/lcomany")
public class LCompanyController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    LPlanRepository lPlanRepository;

    @Autowired
    LPlanDetailsImpl lPlanDetails;

    @PostMapping("/postldetails")
    @PreAuthorize("hasRole('ROLE_LCOMPANY')")
    public LPlan lPlanPost(@RequestBody LPlanRequest lPlanRequest , Authentication authentication){
        UserDetailsImpl userDetails=(UserDetailsImpl) authentication.getPrincipal();
        User user = userRepository.findById(userDetails.getId()).get();
        LPlan lPlan = new LPlan(
                lPlanRequest.getL_plan(),
                lPlanRequest.getL_plan(),
                user
        );
        return lPlanDetails.saveLPlanDetails(lPlan);
    }
}
