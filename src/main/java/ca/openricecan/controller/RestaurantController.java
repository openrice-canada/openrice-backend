package ca.openricecan.controller;

import ca.openricecan.model.RestaurantEntity;
import ca.openricecan.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("")
    public Iterable<RestaurantEntity> getRestaurantList() {
        return restaurantService.getAllRestaurants();
    }
}
