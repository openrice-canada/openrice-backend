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
    @SequenceGenerator(name = "payment_method_sequence", sequenceName = "payment_method_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_method_sequence")
    @Column(name = "payment_method_id", updatable = false, nullable = false)
    private UUID paymentMethodId;

    @Column(name = "name")
    private String name;

    @Column(name = "created_at", updatable = false)
    private final ZonedDateTime createdAt = ZonedDateTime.now();
}
