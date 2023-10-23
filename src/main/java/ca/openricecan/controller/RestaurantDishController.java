package ca.openricecan.controller;

import ca.openricecan.model.entity.restaurant.RestaurantDishEntity;
import ca.openricecan.service.restaurant.RestaurantDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/restaurant/dish")
public class RestaurantDishController {
    private final RestaurantDishService restaurantDishService;

    @Autowired
    public RestaurantDishController(RestaurantDishService restaurantDishService) {
        this.restaurantDishService = restaurantDishService;
    }

    @GetMapping
    public Iterable<RestaurantDishEntity> getRestaurantDishList() {
        return restaurantDishService.getAllRestaurantDishes();
    }

    @GetMapping(path = "{id}")
    public RestaurantDishEntity getRestaurantDishById(@PathVariable UUID id){
        return restaurantDishService.getRestaurantDishById(id);
    }

    @PostMapping
    public RestaurantDishEntity addRestaurantDish(@RequestBody RestaurantDishEntity restaurantDishEntity) {
        return restaurantDishService.addRestaurantDish(restaurantDishEntity);
    }

    @PutMapping(path = "{id}")
    public RestaurantDishEntity editRestaurantDish(@PathVariable UUID id, @RequestBody RestaurantDishEntity restaurantDishEntity) {
        return restaurantDishService.editRestaurantDish(id, restaurantDishEntity);
    }

    @DeleteMapping(path = "{id}")
    public RestaurantDishEntity deleteRestaurantDish(@PathVariable UUID id) {
        return restaurantDishService.deleteRestaurantDish(id);
    }
}
