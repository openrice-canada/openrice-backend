package ca.openricecan.model.entity.restaurant;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "restaurant_dish", schema = "public")
@EntityListeners(AuditingEntityListener.class)
public class RestaurantDishEntity {
    @Id
    @GeneratedValue
    @Column(name = "restaurant_dish_id", updatable = false, nullable = false)
    private UUID restaurantDishId;

    @Column(name = "restaurant_id")
    private UUID restaurantId;

    @Column(name = "dish_id")
    private UUID dishId;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @Column(name = "active")
    private Boolean active = true;

}
