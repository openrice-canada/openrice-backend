package ca.openricecan.model.entity.subscribe;

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
@Table(name = "subscribe", schema = "public")
@EntityListeners(AuditingEntityListener.class)
public class SubscribeEntity {
    @Id
    @GeneratedValue
    @Column(name = "subscribe_id", updatable = false, nullable = false)
    private UUID subscribeId;

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "restaurant_id")
    private UUID restaurantId;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @Column(name = "active")
    private Boolean active = true;

}
