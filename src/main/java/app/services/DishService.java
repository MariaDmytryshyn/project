package app.services;

import app.model.dao.impl.Language;
import app.model.entity.Dish;

import java.util.List;

public interface DishService extends Service<Dish> {
    List<Dish> findByCategory(int categoy_id);
    Dish findByName(String name, Language language);
}
