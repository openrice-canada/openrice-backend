package ca.openricecan.controller;

import ca.openricecan.model.entity.district.DistrictEntity;
import ca.openricecan.service.district.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "district")
public class DistrictController {
  private final DistrictService districtService;

  @Autowired
  public DistrictController(DistrictService districtService) {
    this.districtService = districtService;
  }

  @GetMapping
  public Iterable<DistrictEntity> getDishList() {
    return districtService.getAllDistricts();
  }
}
