package AutoWithAll.AutoWithAll.controllers;


import AutoWithAll.AutoWithAll.models.Packages;
import AutoWithAll.AutoWithAll.models.Payment;
import AutoWithAll.AutoWithAll.models.User;
import AutoWithAll.AutoWithAll.security.services.PaymentDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class PaymentController {

    @Autowired
    PaymentDetailsImpl orderDetails;

    @PostMapping("/payment/{uid}/{pid}")
    public Payment savePayment(@RequestBody Payment payment, @PathVariable("uid") Long uid,@PathVariable("pid") Long pid) {
        System.out.println("=============================");
        User userObj = new User();
        userObj.setId(uid);

        Packages packageObj = new Packages();
        packageObj.setPkgId(pid);

        Payment paymentObj = new Payment();
        paymentObj.setUser(userObj);
        paymentObj.setPackages(packageObj);
        paymentObj.setId(payment.getId());

        return orderDetails.saveOrder(paymentObj);
    }

    @GetMapping("/payment")
    public List<Payment> getAllPayments() {
        return orderDetails.getPayments();
    }
}
