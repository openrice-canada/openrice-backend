package ca.openricecan.controller;

import ca.openricecan.data.entity.payment.PaymentMethodEntity;
import ca.openricecan.service.payment.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "paymentMethod")
public class PaymentMethodController {

    private final PaymentMethodService paymentMethodService;

    @Autowired
    private PaymentMethodController(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    @GetMapping
    public Iterable<PaymentMethodEntity> getPaymentMethodList() {
        return paymentMethodService.getAllPaymentMethods();
    }

    @PostMapping(path = "/createPaymentMethod")
    public void createPaymentMethod(@RequestBody PaymentMethodEntity paymentMethod) {
        paymentMethodService.createPaymentMethod(paymentMethod);
    }
}
