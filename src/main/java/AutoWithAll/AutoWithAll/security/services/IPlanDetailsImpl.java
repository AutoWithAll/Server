package AutoWithAll.AutoWithAll.security.services;

import AutoWithAll.AutoWithAll.models.IPlan;
import AutoWithAll.AutoWithAll.repository.IPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IPlanDetailsImpl {
    @Autowired
    IPlanRepository iPlanRepository;

    public IPlan saveIPlanDetails(IPlan iPlan) { return  iPlanRepository.save(iPlan);
    }
}
