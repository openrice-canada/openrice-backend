package ca.openricecan.controller;

import ca.openricecan.model.entity.dish.DishEntity;
import ca.openricecan.service.dish.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/dish")
public class DishController {
  private final DishService dishService;

  @Autowired
  public DishController(DishService dishService) {
    this.dishService = dishService;
  }

  @GetMapping
  public Iterable<DishEntity> getDishList() {
    return dishService.getAllDishes();
  }

  @GetMapping(path = "{id}")
  public DishEntity getDishById(@PathVariable UUID id) {
    return dishService.getDishById(id);
  }

  @PostMapping
  public DishEntity addDish(@RequestBody DishEntity dishEntity) {
    return dishService.addDish(dishEntity);
  }

  @PutMapping(path = "{id}")
  public DishEntity editDish(@PathVariable UUID id, @RequestBody DishEntity dishEntity) {
    return dishService.editDish(id, dishEntity);
  }

  @DeleteMapping(path = "{id}")
  public DishEntity deleteDish(@PathVariable UUID id) {
    return dishService.deleteDish(id);
  }
}
