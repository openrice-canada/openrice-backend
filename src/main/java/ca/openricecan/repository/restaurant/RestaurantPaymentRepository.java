package ca.openricecan.repository.restaurant;

import ca.openricecan.model.entity.restaurant.RestaurantPaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RestaurantPaymentRepository extends JpaRepository<RestaurantPaymentEntity, UUID> {
}
