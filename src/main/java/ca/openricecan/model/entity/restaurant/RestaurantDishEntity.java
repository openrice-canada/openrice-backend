package ca.openricecan.model.entity.restaurant;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "restaurant_dish", schema = "public")
public class RestaurantDishEntity {
    @Id
    @GeneratedValue
    @Column(name = "restaurant_dish_id", updatable = false, nullable = false)
    private UUID restaurantDishId;

    @Column(name = "restaurant_id")
    private UUID restaurantId;

    @Column(name = "dish_id")
    private UUID dishId;

    @Column(name = "created_at", updatable = false)
    private final ZonedDateTime createdAt = ZonedDateTime.now();
}
