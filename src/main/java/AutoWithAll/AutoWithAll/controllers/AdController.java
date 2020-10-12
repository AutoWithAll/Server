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
import java.util.*;

//Annotation for mapping web requests onto methods in request-handling classes with flexible method signatures.
@CrossOrigin(origins = "*", maxAge = 3600)
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

    // @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/postadd")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_AGENT')")
    public Advertisement AddPost(@RequestBody AdRequest adRequest, Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userRepository.findById(userDetails.getId()).get();

        Date datetime = new Date();

        String[] images = adRequest.getImages();
        byte[] image1 = Base64.getDecoder().decode(images[0].split(",")[1]);
        byte[] image2 = Base64.getDecoder().decode(images[1].split(",")[1]);
        byte[] image3 = Base64.getDecoder().decode(images[2].split(",")[1]);
        byte[] image4 = Base64.getDecoder().decode(images[3].split(",")[1]);
        byte[] image5 = Base64.getDecoder().decode(images[4].split(",")[1]);
        String image1Id = UUID.randomUUID().toString();
        String image2Id = UUID.randomUUID().toString();
        String image3Id = UUID.randomUUID().toString();
        String image4Id = UUID.randomUUID().toString();
        String image5Id = UUID.randomUUID().toString();

        // add 5 images using object array
        class Array {
            protected String imageId;
            protected byte[] image;

            Array(String imageId, byte[] image) {
                this.imageId = imageId;
                this.image = image;
            }
        }
        Array a1 = new Array(image1Id, image1);
        Array a2 = new Array(image2Id, image2);
        Array a3 = new Array(image3Id, image3);
        Array a4 = new Array(image4Id, image4);
        Array a5 = new Array(image5Id, image5);

        Array[] img = {a1, a2, a3, a4, a5};

        for (Array i : img) {
            // System.out.println(i.imageId);
            try (FileOutputStream fos = new FileOutputStream(fileLocation + "/" + i.imageId)) {
                fos.write(i.image);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Advertisement advertisement = new Advertisement(adRequest.getName(), adRequest.getT_number(),
                adRequest.getEmail(), adRequest.getLocation(), adRequest.getTitle(), adRequest.getPrice(),
                adRequest.getV_type(), adRequest.getManufacturer(), adRequest.getModel(), adRequest.getV_condition(),
                adRequest.getM_year(), adRequest.getR_year(), adRequest.getMileage(), adRequest.getE_capacity(),
                adRequest.getTransmission(), adRequest.getFuel_type(), adRequest.getColour(),
                adRequest.getDescription(), image1Id, image2Id, image3Id, image4Id, image5Id, datetime,
                adRequest.getFlag(), adRequest.getlStatus(), adRequest.getiStatus(), user);

        // return userDetails.getUsername();
        return adDetails.saveAdDetails(advertisement);
    }

    //Annotation for mapping HTTP GET requests onto specific handler methods.
    @GetMapping("/getimage/{id}")
    public ResponseEntity<InputStreamResource> getAddImage(@PathVariable String id) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(fileLocation + "/" + id);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(new InputStreamResource(file));
    }

    @GetMapping("/getconfrimad")
    public List<Advertisement> getComnfirmAd() {

        return adRepository.getConfirmAd();
    }

    @GetMapping("/getnewad")
    public List<Advertisement> getPendingAd() {

        return adRepository.getPendingAd();
    }

    @GetMapping("/getAdById/{id}")
    public Optional<Advertisement> gedAdById(@PathVariable Long id) {
        System.out.println(id);
        System.out.println("get add");
        return adRepository.findById(id);
    }

    //Annotation for mapping HTTP POST requests onto specific handler methods.
    @PostMapping("/reportad/{id}")
    public ReportAd ReportAdpost(@PathVariable Long id, @RequestBody ReportAdRequest reportAdRequest) {
        Advertisement advertisement = adRepository.findById(id).get();

        ReportAd reportAd = new ReportAd(reportAdRequest.getReason(), reportAdRequest.getF_name(),
                reportAdRequest.getL_name(), reportAdRequest.getT_number(), reportAdRequest.getEmail(),
                reportAdRequest.getMessage(), advertisement);

        return reportAdDetails.saveReportAdDetails(reportAd);
    }

    @GetMapping("/getAddsByCurrentUser")
    public List<Advertisement> GetAddsByUser(Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userRepository.findById(userDetails.getId()).get();

        return adRepository.findByUser(user);
    }

    @GetMapping("/countremainad")
    public Long CountremainAd(Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userRepository.findById(userDetails.getId()).get();
        return adRepository.rcount(user);
    }

    @GetMapping("/countpostedad")
    public Long CountpostedAd(Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userRepository.findById(userDetails.getId()).get();
        return adRepository.pcount(user);
    }

    // @GetMapping("/")
    // public String index(){
    // return "Fucking hell";
    // }

}
