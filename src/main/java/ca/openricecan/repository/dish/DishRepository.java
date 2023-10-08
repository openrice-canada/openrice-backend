package ca.openricecan.repository.dish;

import ca.openricecan.data.entity.dish.DishEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface DishRepository extends CrudRepository<DishEntity, UUID> {
}
