package ca.openricecan.service;

import ca.openricecan.model.DishEntity;
import ca.openricecan.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DishService {

    private final DishRepository dishRepository;

    @Autowired
    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public Iterable<DishEntity> getAllDishes() {
        return dishRepository.findAll();
    }

    public DishEntity createDish(DishEntity dishEntity) {
        return dishRepository.save(dishEntity);
    }
}
