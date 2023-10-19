package ca.openricecan.repository.district;

import ca.openricecan.model.entity.district.DistrictEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DistrictRepository extends JpaRepository<DistrictEntity, UUID> {
}
