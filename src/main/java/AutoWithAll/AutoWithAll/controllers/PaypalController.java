//package AutoWithAll.AutoWithAll.controllers;
//
//import AutoWithAll.AutoWithAll.payload.request.PaymentRequest;
//import AutoWithAll.AutoWithAll.security.services.PaypalService;
//import com.paypal.api.payments.Payment;
//import com.paypal.base.rest.PayPalRESTException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//@CrossOrigin(origins = "*", maxAge = 3600)
//@RestController
//@RequestMapping("/payment")
//public class PaypalController {
//
//    @Autowired
//    PaypalService service;
//
//    public static final String SUCCESS_URL = "pay/success";
//    public static final String CANCEL_URL = "pay/cancel";
//
//    @GetMapping
//    public String payment(@ModelAttribute("paymentrequest") PaymentRequest paymentRequest){
//        try {
//            Payment payment =  service.createPayment(
//                    paymentRequest.getPrice(),
//                    paymentRequest.getCurrency(),
//                    paymentRequest.getMethod(),
//                    paymentRequest.getDescription(),
//                    "http://localhost:9090/" + CANCEL_URL,
//                    "http://localhost:9090/" + SUCCESS_URL
//            );
//        } catch (PayPalRESTException e) {
//
//        }
//    }
//}
