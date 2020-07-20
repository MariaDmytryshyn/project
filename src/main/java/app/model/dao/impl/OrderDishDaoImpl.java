package app.model.dao.impl;

import app.model.dao.OrderDishDao;
import app.model.dao.mapper.DishMapper;
import app.model.dao.mapper.OrderDishMapper;
import app.model.entity.Dish;
import app.model.entity.OrderDish;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDishDaoImpl implements OrderDishDao {

    private static Logger logger = LogManager.getLogger(OrderDishDaoImpl.class);

    Connection connection;

    public OrderDishDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertDishToOrder(int dish_id, int order_id) {
        String sql = "INSERT INTO order_dish(order_id, dish_id) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, order_id);
            preparedStatement.setInt(2, dish_id);
            preparedStatement.executeUpdate();
            logger.info("Inserted dish to order");
            } catch (SQLException ex) {
            logger.error(ex);
        }
    }

    @Override
    public void deleteDishFromOrder(int dish_id, int order_id) {
        String sql = "delete from order_dish where  order_id=" + order_id + " and dish_id = " + dish_id;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Dish> findDishesOfOrder(int order_id) {
        String sql = "SELECT * from order_dish  where order_id=" + order_id;
        List<Integer> dishes_id= new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            OrderDishMapper orderDishMapper = new OrderDishMapper();
            while (resultSet.next()){
                OrderDish dish = orderDishMapper.extractFromResultSet(resultSet);
                dishes_id.add(dish.getDish_id());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        List<Dish> dishes = new ArrayList<>();
        for(int i :dishes_id){
            String sql_1 = "SELECT * FROM dish WHERE id =" +i;
            try(Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql_1);
                DishMapper dishMapper = new DishMapper();
                while (resultSet.next()){
                    Dish dish = dishMapper.extractFromResultSet(resultSet);
                    dishes.add(dish);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dishes;
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
    public void deleteById(int entityId) {

    }
}
