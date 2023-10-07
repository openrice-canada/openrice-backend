package org.example.repository;

import org.example.model.RestaurantEntity;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<RestaurantEntity,Long> {
}
