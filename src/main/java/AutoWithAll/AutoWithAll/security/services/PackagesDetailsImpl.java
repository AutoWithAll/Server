package AutoWithAll.AutoWithAll.security.services;
import AutoWithAll.AutoWithAll.models.PackagePurchase;
import AutoWithAll.AutoWithAll.models.Packages;
import AutoWithAll.AutoWithAll.repository.PackagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PackagesDetailsImpl {
    @Autowired
    PackagesRepository packagesRepository;
    public Packages savePackages(Packages packages){
        return packagesRepository.save(packages);
    }

    public Optional<Packages> findByPkgId(Long id){
        return packagesRepository.findById(id);
    }
}
