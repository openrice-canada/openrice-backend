package ca.openricecan.service.district;

import ca.openricecan.model.entity.district.DistrictEntity;
import ca.openricecan.repository.district.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DistrictService {
    private final DistrictRepository districtRepository;

    @Autowired
    public DistrictService(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    public Iterable<DistrictEntity> getAllDistricts() {
        return this.districtRepository.findAll();
    }

    public DistrictEntity getDistrictById(UUID id) {
        return districtRepository.findById(id).orElse(null);
    }

    public DistrictEntity addDistrict(DistrictEntity districtEntity) {
        return districtRepository.save(districtEntity);
    }

    public DistrictEntity editDistrict(UUID id, DistrictEntity districtEntity) {
        return districtRepository.findById(id).map(district -> {
            districtEntity.setDistrictId(id);
            return districtRepository.save(districtEntity);
        }).orElse(null);
    }

    public DistrictEntity deleteDistrict(UUID id) {
        return districtRepository.findById(id).map(district -> {
            district.setActive(false);
            return districtRepository.save(district);
        }).orElse(null);
    }
}
