package ca.openricecan.model.entity.restaurant;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "restaurant", schema = "public")
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

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "modified_at")
    private Date modifiedAt;

    @Column(name = "active")
    private Boolean active = true;
//
//    @Column(name = "photo")
//    private String photo;

}