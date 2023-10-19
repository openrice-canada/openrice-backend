package ca.openricecan.model.entity.photo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
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

  @Column(name = "created_at", updatable = false)
  private final ZonedDateTime createdAt = ZonedDateTime.now();
}
