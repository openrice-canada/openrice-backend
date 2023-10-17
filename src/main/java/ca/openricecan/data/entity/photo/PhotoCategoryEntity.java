package ca.openricecan.data.entity.photo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
public class PhotoCategoryEntity {
  @Id
  @Column(name = "photo_category_id", updatable = false, nullable = false)
  private UUID photoCategoryId;

  @Column(name = "name")
  private String name;

  @Column(name = "created_at", updatable = false)
  private final ZonedDateTime createdAt = ZonedDateTime.now();
}
