package ca.openricecan.controller;

import ca.openricecan.data.entity.restaurant.RestaurantOwnerEntity;
import ca.openricecan.service.restaurant.RestaurantOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "restaurant-owner")
public class RestaurantOwnerController {
    private final RestaurantOwnerService restaurantOwnerService;

    @Autowired
    public RestaurantOwnerController(RestaurantOwnerService restaurantOwnerService) {
        this.restaurantOwnerService = restaurantOwnerService;
    }

    @GetMapping
    public Iterable<RestaurantOwnerEntity> getOwnerList() {
        return restaurantOwnerService.getAllRestaurantOwners();
    }
}
