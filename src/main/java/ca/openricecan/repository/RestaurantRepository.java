package ca.openricecan.repository;

import ca.openricecan.model.RestaurantEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RestaurantRepository extends CrudRepository<RestaurantEntity, UUID> {
}
