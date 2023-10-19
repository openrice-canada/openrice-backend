package ca.openricecan.service.restaurant;

import ca.openricecan.model.entity.restaurant.RestaurantEntity;
import ca.openricecan.repository.restaurant.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

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

    public RestaurantEntity getRestaurantById(UUID id) {
        return restaurantRepository.findById(id).orElse(null);
    }

    public RestaurantEntity addRestaurant(RestaurantEntity restaurantEntity) {
        return restaurantRepository.save(restaurantEntity);
    }
}
