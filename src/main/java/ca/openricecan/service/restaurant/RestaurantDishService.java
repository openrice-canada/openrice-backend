package ca.openricecan.service.restaurant;

import ca.openricecan.data.entity.restaurant.RestaurantDishEntity;
import ca.openricecan.repository.restaurant.RestaurantDishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
