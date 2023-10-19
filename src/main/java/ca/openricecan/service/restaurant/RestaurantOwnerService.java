package ca.openricecan.service.restaurant;

import ca.openricecan.model.entity.restaurant.RestaurantOwnerEntity;
import ca.openricecan.repository.restaurant.RestaurantOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantOwnerService {
    private final RestaurantOwnerRepository restaurantOwnerRepository;

    @Autowired
    public RestaurantOwnerService(RestaurantOwnerRepository restaurantOwnerRepository) {
        this.restaurantOwnerRepository = restaurantOwnerRepository;
    }

    public Iterable<RestaurantOwnerEntity> getAllRestaurantOwners() {
        return this.restaurantOwnerRepository.findAll();
    }
}
