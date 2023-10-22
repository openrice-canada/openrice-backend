package ca.openricecan.controller;

import ca.openricecan.model.entity.restaurant.RestaurantOwnerEntity;
import ca.openricecan.service.restaurant.RestaurantOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "restaurant/owner")
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

    @GetMapping(path = "{id}")
    public RestaurantOwnerEntity getRestaurantOwnerById(@PathVariable UUID id){
        return restaurantOwnerService.getRestaurantOwnerById(id);
    }

    @PostMapping
    public RestaurantOwnerEntity addRestaurantOwner(@RequestBody RestaurantOwnerEntity restaurantOwnerEntity) {
        return restaurantOwnerService.addRestaurantOwner(restaurantOwnerEntity);
    }

    @PutMapping(path = "{id}")
    public RestaurantOwnerEntity editRestaurantOwner(@PathVariable UUID id, @RequestBody RestaurantOwnerEntity restaurantOwnerEntity) {
        return restaurantOwnerService.editRestaurantOwner(id, restaurantOwnerEntity);
    }

    @DeleteMapping(path = "{id}")
    public RestaurantOwnerEntity deleteRestaurantOwner(@PathVariable UUID id) {
        return restaurantOwnerService.deleteRestaurantOwner(id);
    }
}
