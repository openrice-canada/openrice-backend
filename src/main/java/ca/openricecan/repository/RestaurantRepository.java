package ca.openricecan.repository;

import ca.openricecan.model.RestaurantEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RestaurantRepository extends CrudRepository<RestaurantEntity, UUID> {
}
