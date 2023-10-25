package ca.openricecan.model.entity.review;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.ZonedDateTime;
import java.util.Date;
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

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "modified_at")
    private Date modifiedAt;

    @Column(name = "active")
    private Boolean active = true;

    @Formula("(select public.user.username from public.user where public.user.user_id = user_id)")
    private String username;

    @Formula("(select restaurant.name from restaurant where restaurant.restaurant_id = restaurant_id)")
    private String restaurantName;

}
