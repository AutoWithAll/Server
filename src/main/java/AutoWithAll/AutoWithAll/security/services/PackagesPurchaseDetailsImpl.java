package AutoWithAll.AutoWithAll.security.services;
import AutoWithAll.AutoWithAll.models.PackagePurchase;
import AutoWithAll.AutoWithAll.models.Packages;
import AutoWithAll.AutoWithAll.repository.PackagesPurchaseRepository;
import AutoWithAll.AutoWithAll.repository.PackagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PackagesPurchaseDetailsImpl {
 @Autowired
 PackagesPurchaseRepository packagesPurchaseRepository;

 public PackagePurchase savePackagesPurchase(PackagePurchase packagePurchase){
     return packagesPurchaseRepository.save(packagePurchase);
 }
}
