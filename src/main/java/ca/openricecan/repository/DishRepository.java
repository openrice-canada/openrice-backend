package ca.openricecan.repository;

import ca.openricecan.model.DishEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface DishRepository extends CrudRepository<DishEntity, UUID> {
}
