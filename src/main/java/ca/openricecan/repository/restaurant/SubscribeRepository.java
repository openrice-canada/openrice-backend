package ca.openricecan.repository.restaurant;

import ca.openricecan.data.entity.restaurant.SubscribeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SubscribeRepository extends JpaRepository<SubscribeEntity, UUID> {
}
