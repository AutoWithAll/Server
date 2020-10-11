package AutoWithAll.AutoWithAll.security.services;
import AutoWithAll.AutoWithAll.models.Packages;
import AutoWithAll.AutoWithAll.repository.PackagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PackagesDetailsImpl {
    @Autowired
    PackagesRepository packagesRepository;
    public Packages savePackages(Packages packages){
        return packagesRepository.save(packages);
    }
}
