package ca.openricecan.service.payment;

import ca.openricecan.model.entity.payment.PaymentMethodEntity;
import ca.openricecan.repository.payment.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

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

    public PaymentMethodEntity getPaymentMethodById(UUID id) {
        return paymentMethodRepository.findById(id).orElse(null);
    }

    public PaymentMethodEntity addPaymentMethod(PaymentMethodEntity paymentMethodEntity) {
        return paymentMethodRepository.save(paymentMethodEntity);
    }

    public PaymentMethodEntity editPaymentMethod(UUID id, PaymentMethodEntity paymentMethodEntity) {
        return paymentMethodRepository.findById(id).map(paymentMethod -> {
            paymentMethodEntity.setPaymentMethodId(id);
            return paymentMethodRepository.save(paymentMethodEntity);
        }).orElse(null);
    }

    public PaymentMethodEntity deletePaymentMethod(UUID id) {
        return paymentMethodRepository.findById(id).map(paymentMethod -> {
            paymentMethod.setActive(false);
            return paymentMethodRepository.save(paymentMethod);
        }).orElse(null);
    }
}
