package ca.openricecan.repository;

import ca.openricecan.model.PaymentMethodEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PaymentMethodRepository extends CrudRepository<PaymentMethodEntity, UUID> {
}
