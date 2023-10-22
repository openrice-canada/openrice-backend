package ca.openricecan.model.entity.photo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "photo_category", schema = "public")
public class PhotoCategoryEntity {
    @Id
    @GeneratedValue
    @Column(name = "photo_category_id", updatable = false, nullable = false)
    private UUID photoCategoryId;

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
