package ca.openricecan.repository.dish;

import ca.openricecan.data.entity.dish.DishEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DishRepository extends CrudRepository<DishEntity, UUID> {
}
