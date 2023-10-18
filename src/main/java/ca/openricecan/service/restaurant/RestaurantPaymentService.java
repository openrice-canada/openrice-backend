package ca.openricecan.service.restaurant;

import ca.openricecan.data.entity.restaurant.RestaurantPaymentEntity;
import ca.openricecan.repository.restaurant.RestaurantPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantPaymentService {
    private final RestaurantPaymentRepository restaurantPaymentRepository;

    @Autowired
    public RestaurantPaymentService(RestaurantPaymentRepository restaurantPaymentRepository) {
        this.restaurantPaymentRepository = restaurantPaymentRepository;
    }

    public Iterable<RestaurantPaymentEntity> getAllRestaurantPayments() {
        return restaurantPaymentRepository.findAll();
    }
}
