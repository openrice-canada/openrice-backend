package ca.openricecan.repository;

import ca.openricecan.model.DishEntity;
import org.springframework.data.repository.CrudRepository;

public interface DishRepository extends CrudRepository<DishEntity,Long> {
}
