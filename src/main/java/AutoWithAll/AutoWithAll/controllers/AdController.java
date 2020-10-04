package AutoWithAll.AutoWithAll.controllers;

import AutoWithAll.AutoWithAll.models.Advertisement;
import AutoWithAll.AutoWithAll.models.ReportAd;
import AutoWithAll.AutoWithAll.models.User;
import AutoWithAll.AutoWithAll.payload.request.AdRequest;
import AutoWithAll.AutoWithAll.payload.request.ReportAdRequest;
import AutoWithAll.AutoWithAll.repository.AdRepository;
import AutoWithAll.AutoWithAll.repository.UserRepository;
import AutoWithAll.AutoWithAll.security.services.AdDetailsImpl;
import AutoWithAll.AutoWithAll.security.services.ReportAdDetailsImpl;
import AutoWithAll.AutoWithAll.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.security.Principal;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/advertisement")
public class AdController {

    @Autowired
    AdDetailsImpl adDetails;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AdRepository adRepository;

    @Autowired
    ReportAdDetailsImpl reportAdDetails;

    @Value("${upload.location}")
    private String fileLocation;

    @PostMapping("/postadd")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_AGENT')")
    public Advertisement AddPost(@RequestBody AdRequest adRequest, Authentication authentication){
        UserDetailsImpl userDetails=(UserDetailsImpl) authentication.getPrincipal();
        User user=userRepository.findById(userDetails.getId()).get();

        String[] images = adRequest.getImages();
        byte[] image1 = Base64.getDecoder().decode(images[0].split(",")[1]);
        String image1Id = UUID.randomUUID().toString();

        try (FileOutputStream fos = new FileOutputStream(fileLocation + "/" + image1Id)) {
            fos.write(image1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Advertisement advertisement = new Advertisement(
                adRequest.getName(),
                adRequest.getT_number(),
                adRequest.getEmail(),
                adRequest.getLocation(),
                adRequest.getTitle(),
                adRequest.getPrice(),
                adRequest.getV_type(),
                adRequest.getManufacturer(),
                adRequest.getModel(),
                adRequest.getV_condition(),
                adRequest.getM_year(),
                adRequest.getR_year(),
                adRequest.getMileage(),
                adRequest.getE_capacity(),
                adRequest.getTransmission(),
                adRequest.getFuel_type(),
                adRequest.getColour(),
                adRequest.getDescription(),
                image1Id,
                adRequest.getFlag(),
                user
        );
        //return  userDetails.getUsername();
        return adDetails.saveAdDetails(advertisement);
    }

    @GetMapping("/getimage/{id}")
    public ResponseEntity<InputStreamResource> getAddImage(@PathVariable String id){
        FileInputStream file = null;
        try {
            file = new FileInputStream(fileLocation + "/" + id);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(new InputStreamResource(file));
    }

    @GetMapping("/getallad")
    public List<Advertisement>getAllAd(){
        return adRepository.findAll();
    }

    @PostMapping("/reportad/{id}")
    public ReportAd ReportAdpost(@PathVariable Long id, @RequestBody ReportAdRequest reportAdRequest ){
        Advertisement advertisement = adRepository.findById(id).get();

        ReportAd reportAd = new ReportAd(
                reportAdRequest.getReason(),
                reportAdRequest.getF_name(),
                reportAdRequest.getL_name(),
                reportAdRequest.getT_number(),
                reportAdRequest.getEmail(),
                reportAdRequest.getMessage(),
                advertisement
                );

        return reportAdDetails.saveReportAdDetails(reportAd);
    }


//    @GetMapping("/")
//    public String index(){
//        return "Fucking hell";
//    }

}
