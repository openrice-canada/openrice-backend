package ca.openricecan.model.entity.payment;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
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

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @Column(name = "active")
    private Boolean active = true;

}
