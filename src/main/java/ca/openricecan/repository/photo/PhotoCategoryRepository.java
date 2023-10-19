package ca.openricecan.repository.photo;

import ca.openricecan.model.entity.photo.PhotoCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PhotoCategoryRepository extends JpaRepository<PhotoCategoryEntity, UUID> {
}
