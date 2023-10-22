package ca.openricecan.service.restaurant;

import ca.openricecan.model.entity.restaurant.RestaurantPaymentEntity;
import ca.openricecan.repository.restaurant.RestaurantPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

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

    public RestaurantPaymentEntity getRestaurantPaymentById(UUID id) {
        return restaurantPaymentRepository.findById(id).orElse(null);
    }

    public RestaurantPaymentEntity addRestaurantPayment(RestaurantPaymentEntity restaurantPaymentEntity) {
        return restaurantPaymentRepository.save(restaurantPaymentEntity);
    }

    public RestaurantPaymentEntity editRestaurantPayment(UUID id, RestaurantPaymentEntity restaurantPaymentEntity) {
        return restaurantPaymentRepository.findById(id).map(restaurantPayment -> {
            restaurantPaymentEntity.setRestaurantPaymentId(id);
            return restaurantPaymentRepository.save(restaurantPaymentEntity);
        }).orElse(null);
    }

    public RestaurantPaymentEntity deleteRestaurantPayment(UUID id) {
        return restaurantPaymentRepository.findById(id).map(restaurantPayment -> {
            restaurantPayment.setActive(false);
            return restaurantPaymentRepository.save(restaurantPayment);
        }).orElse(null);
    }
}
