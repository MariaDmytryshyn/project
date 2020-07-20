package app.model.dao.impl;

import app.model.dao.CategoryDao;
import app.model.dao.OrderDishDao;
import app.model.entity.Dish;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DaoFactoryImpl daoFactory = new DaoFactoryImpl();
        CategoryDao categoryDao = daoFactory.createCategoryDao();
        System.out.println(categoryDao.findOne(1).toString());
        categoryDao.deleteById(10);
        OrderDishDao orderDishDao = daoFactory.createOrderDishDao();
        orderDishDao.insertDishToOrder(1, 1);
        orderDishDao.insertDishToOrder(2, 1);
        orderDishDao.insertDishToOrder(3, 1);
        List<Dish> dishes = orderDishDao.findDishesOfOrder(1);
        System.out.println(dishes);

    }
}
