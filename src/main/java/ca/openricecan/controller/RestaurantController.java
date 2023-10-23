package ca.openricecan.controller;

import ca.openricecan.model.entity.restaurant.RestaurantEntity;
import ca.openricecan.service.restaurant.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/restaurant")
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

//  @PostMapping
//  public RestaurantEntity addRestaurant(@RequestBody RestaurantDTO restaurantDTO, @RequestBody MultipartFile file) throws IOException, SQLException {
//    file.transferTo(new File(`${file.fieldname}-${Date.now()}.${file.mimetype.split('/')[1]}`));
//    byte[] bytes = file.getBytes();file
//    Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
//
//    Image image = new Image();
//    image.setImage(blob);
//    file.transferTo(new File("/path/to/save/file"));
//    restaurantEntity.push();
//    return restaurantService.addRestaurant(restaurantEntity);
//  }

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
