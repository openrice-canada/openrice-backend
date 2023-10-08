package ca.openricecan.service.payment;

import ca.openricecan.data.entity.payment.PaymentMethodEntity;
import ca.openricecan.repository.payment.PaymentMethodRepository;
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

    public void createPaymentMethod(PaymentMethodEntity paymentMethodEntity) {
        paymentMethodRepository.save(paymentMethodEntity);
    }
}
