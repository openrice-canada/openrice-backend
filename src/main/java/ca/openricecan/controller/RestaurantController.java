package ca.openricecan.controller;

import ca.openricecan.data.dto.user.LoginRequest;
import ca.openricecan.data.entity.restaurant.RestaurantEntity;
import ca.openricecan.service.restaurant.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.RepositoryType;
import org.springframework.web.bind.annotation.*;

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
}
