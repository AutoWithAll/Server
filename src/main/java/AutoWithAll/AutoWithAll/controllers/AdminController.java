package AutoWithAll.AutoWithAll.controllers;
import AutoWithAll.AutoWithAll.models.Advertisement;
import AutoWithAll.AutoWithAll.payload.response.MessageResponse;
import AutoWithAll.AutoWithAll.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/admin")

public class AdminController {

    @Autowired
    AdRepository adRepository;


    @PutMapping("/confrim/{adId}")
    @PreAuthorize("hasRole('ROLE_AGENT')")
    public ResponseEntity<?>confrimAd(@PathVariable Long adId){
        Advertisement advertisement = adRepository.findById(adId).get();
        if(advertisement.getFalg() == 0){
            advertisement.setFalg(1);
            adRepository.save(advertisement);
            return ResponseEntity.ok(new MessageResponse("Advertisement Add sucessfully!"));
        }else {
            return  ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Already Add Advertisement!"));
        }
    }

}
