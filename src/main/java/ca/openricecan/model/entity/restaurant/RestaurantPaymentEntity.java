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
@Table(name = "restaurant_payment", schema = "public")
@EntityListeners(AuditingEntityListener.class)
public class RestaurantPaymentEntity {
    @Id
    @GeneratedValue
    @Column(name = "restaurant_payment_id", updatable = false, nullable = false)
    private UUID restaurantPaymentId;

    @Column(name = "restaurant_id")
    private UUID restaurantId;

    @Column(name = "payment_method_id")
    private UUID paymentMethodId;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @Column(name = "active")
    private Boolean active = true;

}
