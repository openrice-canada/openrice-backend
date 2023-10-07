package ca.openricecan.service;

import ca.openricecan.model.DishEntity;
import ca.openricecan.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DishService {
    @Autowired
    private DishRepository dishRepository;

    public Iterable<DishEntity> getAllDishes() {
        return dishRepository.findAll();
    }
}
