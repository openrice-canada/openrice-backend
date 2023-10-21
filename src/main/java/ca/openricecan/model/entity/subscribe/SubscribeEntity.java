package ca.openricecan.model.entity.subscribe;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "subscribe", schema = "public")
public class SubscribeEntity {
  @Id
  @GeneratedValue
  @Column(name = "subscribe_id", updatable = false, nullable = false)
  private UUID subscribeId;

  @Column(name = "user_id")
  private UUID userId;

  @Column(name = "restaurant_id")
  private UUID restaurantId;

  @Column(name = "created_at", updatable = false)
  private final ZonedDateTime createdAt = ZonedDateTime.now();
}
