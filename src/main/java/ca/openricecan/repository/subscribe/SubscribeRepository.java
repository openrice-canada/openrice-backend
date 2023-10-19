package ca.openricecan.repository.subscribe;

import ca.openricecan.model.entity.subscribe.SubscribeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SubscribeRepository extends JpaRepository<SubscribeEntity, UUID> {
}
