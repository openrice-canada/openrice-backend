package ca.openricecan.repository.photo;

import ca.openricecan.model.entity.photo.PhotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PhotoRepository extends JpaRepository<PhotoEntity, UUID> {
}
