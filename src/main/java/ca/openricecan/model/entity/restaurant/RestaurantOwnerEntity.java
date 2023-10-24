package ca.openricecan.model.entity.restaurant;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
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

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @Column(name = "active")
    private Boolean active = true;

}
