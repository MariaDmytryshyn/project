package app.model.dao;

import app.model.dao.impl.Language;
import app.model.entity.Dish;

import java.util.List;

public interface DishDao extends Dao<Dish> {
    List<Dish> findByCategory(int categoy_id);
    Dish findByName(String name, Language language);
}

