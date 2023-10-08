package ca.openricecan.data.entity.payment;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "paymentMethod")
public class PaymentMethodEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
      name = "UUID",
      strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "payment_method_id", updatable = false, nullable = false)
    private UUID paymentMethodId;

    @Column(name = "name")
    private String name;

    @Column(name = "created_at", updatable = false)
    private final ZonedDateTime createdAt = ZonedDateTime.now();
}
