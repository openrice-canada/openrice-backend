package ca.openricecan.controller;

import ca.openricecan.model.entity.payment.PaymentMethodEntity;
import ca.openricecan.service.payment.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "payment-method")
public class PaymentMethodController {
    private final PaymentMethodService paymentMethodService;

    @Autowired
    public PaymentMethodController(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    @GetMapping
    public Iterable<PaymentMethodEntity> getPaymentMethodList() {
        return paymentMethodService.getAllPaymentMethods();
    }

    @GetMapping(path = "{id}")
    public PaymentMethodEntity getPaymentMethodById(@PathVariable UUID id) {
        return paymentMethodService.getPaymentMethodById(id);
    }

    @PostMapping
    public PaymentMethodEntity addPaymentMethod(@RequestBody PaymentMethodEntity paymentMethod) {
        return paymentMethodService.addPaymentMethod(paymentMethod);
    }

    @PutMapping(path = "{id}")
    public PaymentMethodEntity editPaymentMethod(@PathVariable UUID id, @RequestBody PaymentMethodEntity paymentMethodEntity) {
        return paymentMethodService.editPaymentMethod(id, paymentMethodEntity);
    }

    @DeleteMapping(path = "{id}")
    public PaymentMethodEntity deletePaymentMethod(@PathVariable UUID id) {
        return paymentMethodService.deletePaymentMethod(id);
    }
}
