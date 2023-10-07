package ca.openricecan.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "restaurant")
public class RestaurantEntity {
  @Id
  @SequenceGenerator(
    name = "restaurant_sequence",
    sequenceName = "restaurant_sequence",
    allocationSize = 1
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "restaurant_sequence"
  )
//    @Id
//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(
//      name = "UUID",
//      strategy = "org.hibernate.id.UUIDGenerator"
//    )
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

  public UUID getRestaurantId() {
    return restaurantId;
  }

  public void setRestaurantId(UUID restaurantId) {
    this.restaurantId = restaurantId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public UUID getDistrictId() {
    return districtId;
  }

  public void setDistrictId(UUID districtId) {
    this.districtId = districtId;
  }

  public String getCoordinate() {
    return coordinate;
  }

  public void setCoordinate(String coordinate) {
    this.coordinate = coordinate;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getIntro() {
    return intro;
  }

  public void setIntro(String intro) {
    this.intro = intro;
  }

  public String getOpeningHours() {
    return openingHours;
  }

  public void setOpeningHours(String openingHours) {
    this.openingHours = openingHours;
  }

  public UUID getPaymentMethodId() {
    return paymentMethodId;
  }

  public void setPaymentMethodId(UUID paymentMethodId) {
    this.paymentMethodId = paymentMethodId;
  }

  public UUID getDishId() {
    return dishId;
  }

  public void setDishId(UUID dishId) {
    this.dishId = dishId;
  }

  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(ZonedDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public ZonedDateTime getModifiedAt() {
    return modifiedAt;
  }

  public void setModifiedAt(ZonedDateTime modifiedAt) {
    this.modifiedAt = modifiedAt;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }
}