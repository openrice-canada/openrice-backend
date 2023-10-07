package ca.openricecan.controller;

import ca.openricecan.model.PaymentMethodEntity;
import ca.openricecan.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("paymentMethod")
public class PaymentMethodController {

    private final PaymentMethodService paymentMethodService;

    @Autowired
    private PaymentMethodController(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    @GetMapping("")
    public Iterable<PaymentMethodEntity> getPaymentMethodList() {
        return paymentMethodService.getAllPaymentMethods();
    }
}
