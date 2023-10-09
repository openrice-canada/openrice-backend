package ca.openricecan.service.district;

import ca.openricecan.data.entity.district.DistrictEntity;
import ca.openricecan.repository.district.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
