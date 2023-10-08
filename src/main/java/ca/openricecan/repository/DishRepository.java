package ca.openricecan.repository;

import ca.openricecan.model.DishEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DishRepository extends CrudRepository<DishEntity, UUID> {
}
