package AutoWithAll.AutoWithAll.controllers;

import AutoWithAll.AutoWithAll.models.*;
import AutoWithAll.AutoWithAll.payload.request.PackagePurchaseRequest;
import AutoWithAll.AutoWithAll.repository.*;
import AutoWithAll.AutoWithAll.payload.request.SignupRequest;
import AutoWithAll.AutoWithAll.payload.response.MessageResponse;
import AutoWithAll.AutoWithAll.security.services.NormalUserImpl;
import AutoWithAll.AutoWithAll.security.services.PackagesDetailsImpl;
import AutoWithAll.AutoWithAll.security.services.PackagesPurchaseDetailsImpl;
import AutoWithAll.AutoWithAll.security.services.UserDetailsImpl;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/agent")
public class AgentController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository userRoles;

    @Autowired
    AdRepository adRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    NormalUserImpl normalUser;

    @Autowired
    PackagesRepository packagesRepository;

    @Autowired
    PackagesPurchaseDetailsImpl packagesPurchaseDetails;

    @Autowired
    PackagesPurchaseRepository packagesPurchaseRepository;

    @GetMapping("/getad")
    @PreAuthorize("hasRole('ROLE_AGENT')")
    public List<Advertisement> getAgentAd(Authentication authentication){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userRepository.findById(userDetails.getId()).get();
        System.out.println(user.getId());
        return adRepository.findAllByUser(user);

    }
    @PostMapping("/packagepurchase/{pkgId}")
    @PreAuthorize("hasRole('ROLE_AGENT')")
    public ResponseEntity<?> packagePurchase(@PathVariable Long pkgId,@RequestBody PackagePurchaseRequest packagePurchaseRequest,Authentication authentication){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userRepository.findById(userDetails.getId()).get();
        Packages packages = packagesRepository.findById(pkgId).get();
        Date date = new Date();

        PackagePurchase packagePurchase = new PackagePurchase(
                date,
                0,
                packages.getMaxAd(),
                packages,
                user
        );

        packagesPurchaseDetails.savePackagesPurchase(packagePurchase);

        return ResponseEntity.ok(new MessageResponse("Plan Add sucessfully!"));
    }

    @PutMapping("/packageupdate/{pkgId}")
    @PreAuthorize("hasRole('ROLE_AGENT')")
    public ResponseEntity<?>packageUpdate(@PathVariable Long pkgId,Authentication authentication){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userRepository.findById(userDetails.getId()).get();
        Packages packages = packagesRepository.findById(pkgId).get();
        Optional <PackagePurchase> packagePurchase = packagesPurchaseRepository.findAllByUser(user);
        System.out.println(packagePurchase.get().getMaxAdCount());
        if(packagePurchase.get().getMaxAdCount() == packagePurchase.get().getCurrentAdCount()){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Package is over!"));
        }else{
            Integer currendAdCount = packagePurchase.get().getCurrentAdCount() + 1;
            System.out.println(currendAdCount);
            packagePurchase.get().setCurrentAdCount(currendAdCount);
            packagesPurchaseRepository.save(packagePurchase.get());
            return ResponseEntity.ok(new MessageResponse("Plan Add sucessfully!"));
        }

    }



    @GetMapping("/isnewagent")
    @PreAuthorize("hasRole('ROLE_AGENT')")
    public Optional <Boolean> IsNewAgent( Authentication authentication){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userRepository.findById(userDetails.getId()).get();

        return packagesPurchaseRepository.findByUser(user);
    }

//    @GetMapping("/isactive")
//    public ResponseEntity<Boolean> isActive(Authentication authentication){
//        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//        User user = userRepository.findById(userDetails.getId()).get();
//
//        Integer currentCount = this.packagesPurchaseRepository.findByUserAndCurrentAdCount(user);
//        System.out.println(currentCount);
//        return ResponseEntity.ok(true);
////        Optional <Boolean> isActive = this.packagesPurchaseRepository.findByUser(user);
////        if(this.packagesPurchaseRepository.findByUser(user) != null){
////            return ResponseEntity.ok(true);
////        }
////        return ResponseEntity.badRequest().body(false);
//    }
    @GetMapping("/getallagent")
    public List <Role> getAgents(Authentication authentication){
        return userRoles.findAllByName(ERole.ROLE_AGENT);
    }

}
