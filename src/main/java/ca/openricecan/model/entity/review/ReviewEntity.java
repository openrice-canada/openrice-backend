package ca.openricecan.model.entity.review;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "review", schema = "public")
public class ReviewEntity {
  @Id
  @GeneratedValue
  @Column(name = "review_id", updatable = false, nullable = false)
  private UUID reviewId;

  @Column(name = "user_id", nullable = false)
  private UUID userId;

  @Column(name = "restaurant_id", nullable = false)
  private UUID restaurantId;

  @Column(name = "rating")
  private Integer rating;

  @Column(name = "title")
  private String title;

  @Column(name = "visit_date")
  private ZonedDateTime visitDate;

  @Column(name = "content")
  private String content;

  @Column(name = "spending")
  private Integer spending;

  @Column(name = "created_at", updatable = false)
  private ZonedDateTime createdAt;

  @Column(name = "modified_at")
  private ZonedDateTime modifiedAt;

  @Column(name = "active")
  private Boolean active;

  @Formula("(select public.user.username from public.user where public.user.user_id = user_id)")
  private String username;

  @Formula("(select restaurant.name from restaurant where restaurant.restaurant_id = restaurant_id)")
  private String restaurantName;

  @PrePersist
  void onPrePersist() {
    this.setActive(true);
    this.setCreatedAt(ZonedDateTime.now());
    this.setModifiedAt(ZonedDateTime.now());
  }

  @PreUpdate
  void onUpdate() {
    this.setModifiedAt(ZonedDateTime.now());
  }
}
