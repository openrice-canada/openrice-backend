package ca.openricecan.service.dish;

import ca.openricecan.model.entity.dish.DishEntity;
import ca.openricecan.repository.dish.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

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

    public DishEntity getDishById(UUID id) {
        return dishRepository.findById(id).orElse(null);
    }

    public DishEntity addDish(DishEntity dishEntity) {
        return dishRepository.save(dishEntity);
    }

    public DishEntity editDish(UUID id, DishEntity dishEntity) {
        return dishRepository.findById(id).map(dish -> {
            dishEntity.setDishId(id);
            return dishRepository.save(dishEntity);
        }).orElse(null);
    }

    public DishEntity deleteDish(UUID id) {
        return dishRepository.findById(id).map(dish -> {
            dish.setActive(false);
            return dishRepository.save(dish);
        }).orElse(null);
    }
}
