package ca.openricecan.model.entity.restaurant;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "restaurant_owner", schema = "public")
public class RestaurantOwnerEntity {
    @Id
    @GeneratedValue
    @Column(name = "owner_id", updatable = false, nullable = false)
    private UUID ownerId;

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "restaurant_id")
    private UUID restaurantId;

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
