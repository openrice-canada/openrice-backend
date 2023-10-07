package ca.openricecan.repository;

import ca.openricecan.model.PaymentMethodEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PaymentMethodRepository extends CrudRepository<PaymentMethodEntity, UUID> {
}
