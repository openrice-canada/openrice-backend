package ca.openricecan.repository.restaurant;

import ca.openricecan.data.entity.restaurant.RestaurantOwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RestaurantOwnerRepository extends JpaRepository<RestaurantOwnerEntity, UUID> {
}
