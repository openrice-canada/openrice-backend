package org.example.model;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "restaurant")
public class RestaurantEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "restaurant_id", updatable = false, nullable = false)
    private UUID restaurantId;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "district_id")
    private UUID districtId;

    @Column(name = "coordinate")
    private String coordinate;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "phone")
    private String phone;

    @Column(name = "intro")
    private String intro;

    @Column(name = "opening_hours")
    private String openingHours;

    @Column(name = "payment_method_id")
    private UUID paymentMethodId;

    @Column(name = "dish_id")
    private UUID dishId;

    @Column(name = "created_at", updatable = false)
    private ZonedDateTime createdAt = ZonedDateTime.now();

    @Column(name = "modified_at")
    private ZonedDateTime modifiedAt;

    @Column(name = "active")
    private boolean active;


}