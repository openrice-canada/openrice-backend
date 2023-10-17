package ca.openricecan.repository.restaurant;

import ca.openricecan.data.entity.restaurant.RestaurantEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RestaurantRepository extends CrudRepository<RestaurantEntity, UUID> {
}
