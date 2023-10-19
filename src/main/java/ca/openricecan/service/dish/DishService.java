package ca.openricecan.service.dish;

import ca.openricecan.model.entity.dish.DishEntity;
import ca.openricecan.repository.dish.DishRepository;
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

    public void createDish(DishEntity dishEntity) {
        dishRepository.save(dishEntity);
    }
}
