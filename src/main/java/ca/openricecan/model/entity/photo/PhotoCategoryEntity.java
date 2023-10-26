package ca.openricecan.model.entity.photo;

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
@Table(name = "photo_category", schema = "public")
@EntityListeners(AuditingEntityListener.class)
public class PhotoCategoryEntity {
    @Id
    @GeneratedValue
    @Column(name = "photo_category_id", updatable = false, nullable = false)
    private UUID photoCategoryId;

    @Column(name = "name")
    private String name;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @Column(name = "active")
    private Boolean active = true;

}
