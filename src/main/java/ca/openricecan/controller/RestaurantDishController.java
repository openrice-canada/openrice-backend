package ca.openricecan.controller;

import ca.openricecan.data.entity.restaurant.RestaurantDishEntity;
import ca.openricecan.service.restaurant.RestaurantDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "restaurant-dish")
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
}
