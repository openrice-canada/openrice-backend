package ca.openricecan.repository.payment;

import ca.openricecan.data.entity.payment.PaymentMethodEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PaymentMethodRepository extends CrudRepository<PaymentMethodEntity, UUID> {
}
