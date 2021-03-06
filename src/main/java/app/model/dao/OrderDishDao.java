package app.model.dao;

import app.model.entity.Dish;
import app.model.entity.OrderDish;

import java.util.List;

public interface OrderDishDao extends Dao<OrderDish> {
    void insertDishToOrder(int dish_id, int order_id);
    void deleteDishFromOrder(int dish_id, int order_id);
    List<Dish> findDishesOfOrder(int order_id);
}
