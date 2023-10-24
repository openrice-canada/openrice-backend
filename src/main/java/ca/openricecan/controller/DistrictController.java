package ca.openricecan.controller;

import ca.openricecan.model.entity.district.DistrictEntity;
import ca.openricecan.service.district.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/district")
public class DistrictController {
  private final DistrictService districtService;

  @Autowired
  public DistrictController(DistrictService districtService) {
    this.districtService = districtService;
  }

  @GetMapping
  public Iterable<DistrictEntity> getDistrictList() {
    return districtService.getAllDistricts();
  }

  @GetMapping(path = "{id}")
  public DistrictEntity getDistrictById(@PathVariable UUID id) {
    return districtService.getDistrictById(id);
  }

  @PostMapping
  public DistrictEntity addDistrict(@RequestBody DistrictEntity districtEntity) {
    return districtService.addDistrict(districtEntity);
  }

  @PutMapping(path = "{id}")
  public DistrictEntity editDistrict(@PathVariable UUID id, @RequestBody DistrictEntity districtEntity) {
    return districtService.editDistrict(id, districtEntity);
  }

  @DeleteMapping(path = "{id}")
  public DistrictEntity deleteDistrict(@PathVariable UUID id) {
    return districtService.deleteDistrict(id);
  }
}
