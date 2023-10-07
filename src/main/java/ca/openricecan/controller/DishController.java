package ca.openricecan.controller;

import ca.openricecan.model.DishEntity;
import ca.openricecan.service.DishService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dish")
public class DishController {
    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("")
    public Iterable<DishEntity> getDishList() {
        return dishService.getAllDishes();
    }
}
