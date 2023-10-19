package ca.openricecan.repository.dish;

import ca.openricecan.model.entity.dish.DishEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DishRepository extends JpaRepository<DishEntity, UUID> {
}
