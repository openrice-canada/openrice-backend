package ca.openricecan.model.entity.restaurant;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "restaurant", schema = "public")
@EntityListeners(AuditingEntityListener.class)
public class RestaurantEntity {
    @Id
    @GeneratedValue
    @Column(name = "restaurant_id", updatable = false, nullable = false)
    private UUID restaurantId;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "district_id")
    private UUID districtId;

    @Column(name = "latitude")
    private Float latitude;

    @Column(name = "longitude")
    private Float longitude;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "phone")
    private String phone;

    @Column(name = "intro")
    private String intro;

    @Column(name = "opening_hours")
    private String openingHours;

    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @Column(name = "modified_at")
    private Date modifiedAt;

    @Column(name = "active")
    private Boolean active = true;

    @Formula("(select sum(review.rating)/count(review.rating) from review where review.restaurant_id = restaurant_id)")
    private Float averageRating;

    @Formula("(select count(review.rating) from review where review.restaurant_id = restaurant_id)")
    private Integer reviewCount;

}