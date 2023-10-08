package ca.openricecan.service.restaurant;

import ca.openricecan.data.entity.restaurant.RestaurantEntity;
import ca.openricecan.repository.restaurant.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository=restaurantRepository;
    }

    public Iterable<RestaurantEntity> getAllRestaurants() {
        return restaurantRepository.findAll();
    }
}
