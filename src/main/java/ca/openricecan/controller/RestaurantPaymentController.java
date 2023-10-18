package ca.openricecan.controller;

import ca.openricecan.data.entity.restaurant.RestaurantPaymentEntity;
import ca.openricecan.service.restaurant.RestaurantPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/restaurant/payment")
public class RestaurantPaymentController {
    private final RestaurantPaymentService restaurantPaymentService;

    @Autowired
    public RestaurantPaymentController(RestaurantPaymentService restaurantPaymentService) {
        this.restaurantPaymentService = restaurantPaymentService;
    }

    @GetMapping
    public Iterable<RestaurantPaymentEntity> getRestaurantPaymentList() {
        return restaurantPaymentService.getAllRestaurantPayments();
    }
}
