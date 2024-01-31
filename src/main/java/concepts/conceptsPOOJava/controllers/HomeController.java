package concepts.conceptsPOOJava.controllers;

import concepts.conceptsPOOJava.data.factories.PaymentFactory;
import concepts.conceptsPOOJava.data.interfaces.IPaymentMethod;
import concepts.conceptsPOOJava.data.responses.PaymentResponse;
import concepts.conceptsPOOJava.services.PaymentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HomeController {
    @Qualifier(value = "PaymentFactory")
    private final PaymentFactory paymentFactory;

    @Qualifier(value = "PaymentService")
    private final PaymentService paymentService;

    private final PaymentResponse paymentResponse;

    public HomeController(PaymentFactory paymentFactory, PaymentService paymentService, PaymentResponse paymentResponse) {
        this.paymentFactory = paymentFactory;
        this.paymentService = paymentService;
        this.paymentResponse = paymentResponse;
    }

    @GetMapping("/payment")
    public PaymentResponse payment() {
        try {
            IPaymentMethod paymentMethod = paymentFactory.create("Nequi");
            this.paymentService.setPaymentMethod(paymentMethod);
            String result = this.paymentService.process();
            this.paymentResponse.setMessage(result, HttpStatus.OK);
            return this.paymentResponse;
        } catch (Exception e) {
            this.paymentResponse.setMessage("Error processing payment: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            return this.paymentResponse;
        }
    }
}
