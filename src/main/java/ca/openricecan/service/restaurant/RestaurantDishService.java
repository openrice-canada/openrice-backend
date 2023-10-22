package ca.openricecan.service.restaurant;

import ca.openricecan.model.entity.restaurant.RestaurantDishEntity;
import ca.openricecan.repository.restaurant.RestaurantDishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RestaurantDishService {
    private final RestaurantDishRepository restaurantDishRepository;

    @Autowired
    public RestaurantDishService(RestaurantDishRepository restaurantDishRepository) {
        this.restaurantDishRepository = restaurantDishRepository;
    }

    public Iterable<RestaurantDishEntity> getAllRestaurantDishes() {
        return restaurantDishRepository.findAll();
    }

    public RestaurantDishEntity getRestaurantDishById(UUID id) {
        return restaurantDishRepository.findById(id).orElse(null);
    }

    public RestaurantDishEntity addRestaurantDish(RestaurantDishEntity restaurantDishEntity) {
        return restaurantDishRepository.save(restaurantDishEntity);
    }

    public RestaurantDishEntity editRestaurantDish(UUID id, RestaurantDishEntity restaurantDishEntity) {
        return restaurantDishRepository.findById(id).map(restaurantDish -> {
            restaurantDishEntity.setRestaurantDishId(id);
            return restaurantDishRepository.save(restaurantDishEntity);
        }).orElse(null);
    }

    public RestaurantDishEntity deleteRestaurantDish(UUID id) {
        return restaurantDishRepository.findById(id).map(restaurantDish -> {
            restaurantDish.setActive(false);
            return restaurantDishRepository.save(restaurantDish);
        }).orElse(null);
    }
}
