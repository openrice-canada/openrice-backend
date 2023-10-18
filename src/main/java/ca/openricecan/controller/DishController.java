package ca.openricecan.controller;

import ca.openricecan.data.entity.dish.DishEntity;
import ca.openricecan.service.dish.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/dish")
public class DishController {
    private final DishService dishService;

    @Autowired
    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping
    public Iterable<DishEntity> getDishList() {
        return dishService.getAllDishes();
    }

    @PostMapping
    public void createDish(@RequestBody DishEntity dishEntity) {
        dishService.createDish(dishEntity);
    }
}
