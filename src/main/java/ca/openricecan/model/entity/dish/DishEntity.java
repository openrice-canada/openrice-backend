package ca.openricecan.model.entity.dish;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "dish", schema = "public")
@EntityListeners(AuditingEntityListener.class)
public class DishEntity {
    @Id
    @GeneratedValue
    @Column(name = "dish_id", updatable = false, nullable = false)
    private UUID dishId;

    @Column(name = "name")
    private String name;

    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @Column(name = "active")
    private Boolean active = true;

}
