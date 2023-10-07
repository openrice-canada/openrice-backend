package ca.openricecan.repository;

import ca.openricecan.model.RestaurantEntity;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<RestaurantEntity,Long> {
}
