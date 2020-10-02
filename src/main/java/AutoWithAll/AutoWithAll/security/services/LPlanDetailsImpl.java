package AutoWithAll.AutoWithAll.security.services;

import AutoWithAll.AutoWithAll.models.LPlan;
import AutoWithAll.AutoWithAll.repository.LPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LPlanDetailsImpl {
    @Autowired
    LPlanRepository lPlanRepository;

    public LPlan saveLPlanDetails(LPlan lPlan){
        return lPlanRepository.save(lPlan);
    }
}
