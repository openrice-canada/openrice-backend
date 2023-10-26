package ca.openricecan.service.restaurant;

import ca.openricecan.model.entity.restaurant.RestaurantEntity;
import ca.openricecan.repository.restaurant.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Iterable<RestaurantEntity> searchRestaurant(
            String name,
            Integer limit,
            Integer offset
    ) {
        if (name == null) return restaurantRepository.findAll().stream()
                .skip(offset)
                .limit(limit)
                .toList();
        return restaurantRepository.findAll().stream()
                .filter(restaurant -> restaurant.getName().toLowerCase().contains(name.toLowerCase()))
                .skip(offset)
                .limit(limit)
                .toList();
    }

    public RestaurantEntity getRestaurantById(UUID id) {
        return restaurantRepository.findById(id).orElse(null);
    }

    public RestaurantEntity addRestaurant(RestaurantEntity restaurantEntity) {
        return restaurantRepository.save(restaurantEntity);
    }

    public RestaurantEntity editRestaurant(UUID id, RestaurantEntity restaurantEntity) {
        return restaurantRepository.findById(id).map(restaurant -> {
            restaurant = restaurantEntity;
            restaurant.setRestaurantId(id);
            return restaurantRepository.save(restaurant);
        }).orElse(null);
    }

    public RestaurantEntity deleteRestaurant(UUID id) {
        return restaurantRepository.findById(id).map(restaurant -> {
            restaurant.setActive(false);
            return restaurantRepository.save(restaurant);
        }).orElse(null);
    }
}
