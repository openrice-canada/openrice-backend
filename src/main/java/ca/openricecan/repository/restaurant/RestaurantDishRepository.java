package ca.openricecan.repository.restaurant;

import ca.openricecan.data.entity.restaurant.RestaurantDishEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RestaurantDishRepository extends JpaRepository<RestaurantDishEntity, UUID> {
}
