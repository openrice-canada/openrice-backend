package ca.openricecan.controller;

import ca.openricecan.data.entity.restaurant.RestaurantEntity;
import ca.openricecan.service.restaurant.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping(path = "restaurant")
public class RestaurantController {
    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public Iterable<RestaurantEntity> getRestaurantList() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping(path = "{id}")
    public RestaurantEntity getRestaurantById(@PathVariable UUID id) {
        return restaurantService.getRestaurantById(id);
    }

    @PostMapping
    public RestaurantEntity addRestaurant(@RequestBody RestaurantEntity restaurantEntity) {
        return restaurantService.addRestaurant(restaurantEntity);
    }
}
