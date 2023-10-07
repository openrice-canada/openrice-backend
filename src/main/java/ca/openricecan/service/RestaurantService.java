package ca.openricecan.service;

import ca.openricecan.model.RestaurantEntity;
import ca.openricecan.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public Iterable<RestaurantEntity> getAllRestaurants() {
        return restaurantRepository.findAll();
    }
}
