package AutoWithAll.AutoWithAll.controllers;
import AutoWithAll.AutoWithAll.models.Packages;
import AutoWithAll.AutoWithAll.models.User;
import AutoWithAll.AutoWithAll.payload.request.PackagesRequest;
import AutoWithAll.AutoWithAll.payload.response.MessageResponse;
import AutoWithAll.AutoWithAll.repository.UserRepository;
import AutoWithAll.AutoWithAll.security.services.PackagesDetailsImpl;
import AutoWithAll.AutoWithAll.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/package")


public class PackageController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PackagesDetailsImpl packagesDetails;

    @PostMapping("/addpackage")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> addPackage(@RequestBody PackagesRequest packagesRequest,Authentication authentication){
        Packages packages=new Packages(
                packagesRequest.getPackageName(),
                packagesRequest.getPrice(),
                packagesRequest.getMaxAd(),
                packagesRequest.getCreationDate(),
                packagesRequest.getEndingDate()
        );
        packagesDetails.savePackages(packages);
        return ResponseEntity.ok(new MessageResponse("Package Add Succeefully!"));
    }
}
