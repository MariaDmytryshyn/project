package app.services.impl;

import app.model.dao.DaoFactory;
import app.model.dao.OrderDishDao;
import app.model.entity.Dish;
import app.model.entity.OrderDish;

import java.util.List;

public class OrderDishService implements app.services.OrderDishService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public void insertDishToOrder(int dish_id, int order_id) {
        OrderDishDao orderDishDao = daoFactory.createOrderDishDao();
        orderDishDao.insertDishToOrder(dish_id, order_id);

    }

    @Override
    public void deleteDishFromOrder(int dish_id, int order_id) {
        OrderDishDao orderDishDao = daoFactory.createOrderDishDao();
        orderDishDao.deleteDishFromOrder(dish_id, order_id);
    }

    @Override
    public List<Dish> findDishesOfOrder(int order_id) {
        OrderDishDao orderDishDao = daoFactory.createOrderDishDao();
        return orderDishDao.findDishesOfOrder(order_id);
    }

    @Override
    public OrderDish findOne(int id) {
        return null;
    }

    @Override
    public List<OrderDish> findAll() {
        return null;
    }

    @Override
    public OrderDish insert(OrderDish entity) {
        return null;
    }

    @Override
    public boolean update(OrderDish entity) {
        return false;
    }

    @Override
    public boolean deleteById(int entityId) {
        return false;
    }
}
