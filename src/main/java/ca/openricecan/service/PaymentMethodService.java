package ca.openricecan.service;

import ca.openricecan.model.PaymentMethodEntity;
import ca.openricecan.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodService {

    private final PaymentMethodRepository paymentMethodRepository;

    @Autowired
    public PaymentMethodService(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    public Iterable<PaymentMethodEntity> getAllPaymentMethods() {
        return paymentMethodRepository.findAll();
    }
}
