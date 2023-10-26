package ca.openricecan.model.entity.restaurant;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "restaurant_payment", schema = "public")
public class RestaurantPaymentEntity {
    @Id
    @GeneratedValue
    @Column(name = "restaurant_payment_id", updatable = false, nullable = false)
    private UUID restaurantPaymentId;

    @Column(name = "restaurant_id")
    private UUID restaurantId;

    @Column(name = "payment_method_id")
    private UUID paymentMethodId;

    @Column(name = "created_at", updatable = false)
    private ZonedDateTime createdAt;

    @Column(name = "active")
    private Boolean active;

    @PrePersist
    void onPrePersist() {
        this.setActive(true);
        this.setCreatedAt(ZonedDateTime.now());
    }

}
