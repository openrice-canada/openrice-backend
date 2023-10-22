package ca.openricecan.model.entity.dish;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "dish", schema = "public")
public class DishEntity {
    @Id
    @GeneratedValue
    @Column(name = "dish_id", updatable = false, nullable = false)
    private UUID dishId;

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
