package ca.openricecan.controller;

import ca.openricecan.model.entity.restaurant.RestaurantPaymentEntity;
import ca.openricecan.service.restaurant.RestaurantPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/restaurant/payment")
public class RestaurantPaymentController {
  private final RestaurantPaymentService restaurantPaymentService;

  @Autowired
  public RestaurantPaymentController(RestaurantPaymentService restaurantPaymentService) {
    this.restaurantPaymentService = restaurantPaymentService;
  }

  @GetMapping
  public Iterable<RestaurantPaymentEntity> getRestaurantPaymentList() {
    return restaurantPaymentService.getAllRestaurantPayments();
  }

  @GetMapping(path = "{id}")
  public RestaurantPaymentEntity getRestaurantPaymentById(@PathVariable UUID id) {
    return restaurantPaymentService.getRestaurantPaymentById(id);
  }

  @PostMapping
  public RestaurantPaymentEntity addRestaurantPayment(@RequestBody RestaurantPaymentEntity restaurantPaymentEntity) {
    return restaurantPaymentService.addRestaurantPayment(restaurantPaymentEntity);
  }

  @PutMapping(path = "{id}")
  public RestaurantPaymentEntity editRestaurantPayment(@PathVariable UUID id, @RequestBody RestaurantPaymentEntity restaurantPaymentEntity) {
    return restaurantPaymentService.editRestaurantPayment(id, restaurantPaymentEntity);
  }

  @DeleteMapping(path = "{id}")
  public RestaurantPaymentEntity deleteRestaurantPayment(@PathVariable UUID id) {
    return restaurantPaymentService.deleteRestaurantPayment(id);
  }
}
