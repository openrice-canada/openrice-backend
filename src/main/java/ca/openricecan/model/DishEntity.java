package ca.openricecan.model;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "dish")
public class DishEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "dish_id", updatable = false, nullable = false)
    public UUID dishId;

    @Column(name = "name")
    public String name;

    @Column(name = "created_at", updatable = false)
    public ZonedDateTime createdAt = ZonedDateTime.now();

}
