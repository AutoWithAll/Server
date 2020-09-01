package AutoWithAll.AutoWithAll.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping("/all")
    public String allAccess(){
        return "Public Content";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_LCOMPANY') or hasRole('ROLE_ICOMPANY') or hasRole('ROLE_ADMIN') or hasRole('ROLE_AGENT')")
    public String userAccess(){
        return "User Content.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String adminAccess(){
        return "Admin Board.";
    }

    @GetMapping("/agent")
    @PreAuthorize("hasRole('ROLE_AGENT')")
    public String agentAccess(){
        return "Agent Board.";
    }

    @GetMapping("/lcompany")
    @PreAuthorize("hasRole('ROLE_LCOMPANY')")
    public String lcompanyAccess(){
        return "Lcompany Board.";
    }

    @GetMapping("/icompany")
    @PreAuthorize("hasRole('ROLE_ICOMPANY')")
    public String icompanyAccess(){
        return "Lcompany Board.";
    }

}
