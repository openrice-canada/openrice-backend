package ca.openricecan.service.restaurant;

import ca.openricecan.model.entity.restaurant.RestaurantOwnerEntity;
import ca.openricecan.repository.restaurant.RestaurantOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

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

    public RestaurantOwnerEntity getRestaurantOwnerById(UUID id) {
        return restaurantOwnerRepository.findById(id).orElse(null);
    }

    public RestaurantOwnerEntity addRestaurantOwner(RestaurantOwnerEntity restaurantOwnerEntity) {
        return restaurantOwnerRepository.save(restaurantOwnerEntity);
    }

    public RestaurantOwnerEntity editRestaurantOwner(UUID id, RestaurantOwnerEntity restaurantOwnerEntity) {
        return restaurantOwnerRepository.findById(id).map(restaurantOwner -> {
            restaurantOwnerEntity.setOwnerId(id);
            return restaurantOwnerRepository.save(restaurantOwnerEntity);
        }).orElse(null);
    }

    public RestaurantOwnerEntity deleteRestaurantOwner(UUID id) {
        return restaurantOwnerRepository.findById(id).map(restaurantOwner -> {
            restaurantOwner.setActive(false);
            return restaurantOwnerRepository.save(restaurantOwner);
        }).orElse(null);
    }
}
