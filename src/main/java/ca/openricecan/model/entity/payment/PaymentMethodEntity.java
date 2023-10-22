package ca.openricecan.model.entity.payment;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "payment_method", schema = "public")
public class PaymentMethodEntity {
    @Id
    @GeneratedValue
    @Column(name = "payment_method_id", updatable = false, nullable = false)
    private UUID paymentMethodId;

    @Column(name = "name")
    private String name;

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
