//package AutoWithAll.AutoWithAll.controllers;
//
//import AutoWithAll.AutoWithAll.models.Test;
//import AutoWithAll.AutoWithAll.payload.request.TestRequest;
//import AutoWithAll.AutoWithAll.repository.TestRepository;
//import AutoWithAll.AutoWithAll.security.services.TestDetailsImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//
//@CrossOrigin(origins = "*",maxAge = 3600)
//@RestController
//@RequestMapping("/api/test")
//public class TestController {
//    @GetMapping("/all")
//    public String allAccess(){
//        return "Public Content";
//    }
//
//    @GetMapping("/user")
//    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_LCOMPANY') or hasRole('ROLE_ICOMPANY') or hasRole('ROLE_ADMIN') or hasRole('ROLE_AGENT')")
//    public String userAccess(){
//        return "User Content.";
//    }
//
//    @GetMapping("/admin")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    public String adminAccess(){
//        return "Admin Board.";
//    }
//
//    @GetMapping("/agent")
//    @PreAuthorize("hasRole('ROLE_AGENT')")
//    public String agentAccess(){
//        return "Agent Board.";
//    }
//
//    @GetMapping("/lcompany")
//    @PreAuthorize("hasRole('ROLE_LCOMPANY')")
//    public String lcompanyAccess(){
//        return "Lcompany Board.";
//    }
//
//    @GetMapping("/icompany")
//    @PreAuthorize("hasRole('ROLE_ICOMPANY')")
//    public String icompanyAccess(){
//        return "Lcompany Board.";
//    }
//
//    @Autowired
//    TestDetailsImpl testDetails;
//    //Example
//    @PostMapping("/test")
//    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_LCOMPANY') or hasRole('ROLE_ICOMPANY') or hasRole('ROLE_ADMIN') or hasRole('ROLE_AGENT')")
//    public Test saveTest(@RequestBody TestRequest testRequest){
//        Test test = new Test(
//                testRequest.getName(),
//                testRequest.getAge()
//        );
//        return testDetails.saveTestDetails(test);
//
//    }
//
//    @Autowired
//    TestRepository testRepository;
//    @PutMapping("/update")
//    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_LCOMPANY') or hasRole('ROLE_ICOMPANY') or hasRole('ROLE_ADMIN') or hasRole('ROLE_AGENT')")
//    public Test updateTest(@RequestBody Test test){
//        return testDetails.editTestDetails(test);
//    }
//    @DeleteMapping("/delete/{id}")
//    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_LCOMPANY') or hasRole('ROLE_ICOMPANY') or hasRole('ROLE_ADMIN') or hasRole('ROLE_AGENT')")
//    public String deleteTestDetails(@PathVariable Long id){
//        return testDetails.deleteTestDetails(id);
//    }
//
//}
