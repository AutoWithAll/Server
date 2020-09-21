package AutoWithAll.AutoWithAll.security.services;

import AutoWithAll.AutoWithAll.models.Advertisement;
import AutoWithAll.AutoWithAll.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdDetailsImpl {
    @Autowired
    AdRepository adRepository;

    public Advertisement saveAdDetails(Advertisement advertisement){
        return adRepository.save(advertisement);
    }
}
