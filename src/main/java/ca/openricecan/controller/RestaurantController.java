package ca.openricecan.controller;

import ca.openricecan.model.entity.restaurant.RestaurantEntity;
import ca.openricecan.service.restaurant.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/restaurant")
public class RestaurantController {
  private final RestaurantService restaurantService;

  @Autowired
  public RestaurantController(RestaurantService restaurantService) {
    this.restaurantService = restaurantService;
  }

  @GetMapping
  public Iterable<RestaurantEntity> getRestaurantList(
    @RequestParam(required = false) String name,
    @RequestParam(defaultValue = "10") Integer limit,
    @RequestParam(defaultValue = "0") Integer offset
  ) {
    return restaurantService.searchRestaurant(name, limit, offset);
  }

  @GetMapping(path = "{id}")
  public RestaurantEntity getRestaurantById(@PathVariable UUID id) {
    return restaurantService.getRestaurantById(id);
  }

  @PostMapping
  public RestaurantEntity addRestaurant(@RequestBody RestaurantEntity restaurantEntity) {
    return restaurantService.addRestaurant(restaurantEntity);
  }

  @PutMapping(path = "{id}")
  public RestaurantEntity editRestaurant(@PathVariable UUID id, @RequestBody RestaurantEntity restaurantEntity) {
    return restaurantService.editRestaurant(id, restaurantEntity);
  }

  @DeleteMapping(path = "{id}")
  public RestaurantEntity deleteRestaurant(@PathVariable UUID id) {
    return restaurantService.deleteRestaurant(id);
  }
}
