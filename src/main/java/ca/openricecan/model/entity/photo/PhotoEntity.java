package ca.openricecan.model.entity.photo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "photo", schema = "public")
public class PhotoEntity {
    @Id
    @GeneratedValue
    @Column(name = "photo_id", updatable = false, nullable = false)
    private UUID photoId;

    @Column(name = "review_id")
    private UUID reviewId;

    @Column(name = "photo_category_id")
    private UUID photoCategoryId;

    @Column(name = "photo_address")
    private String photoAddress;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @Column(name = "active")
    private Boolean active = true;

}
