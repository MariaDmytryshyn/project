package app.model.dao.impl;

import app.model.dao.OrdersDao;
import app.model.dao.mapper.OrderMapper;
import app.model.entity.Dish;
import app.model.entity.Orders;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrdersDao {

    private static Logger logger = LogManager.getLogger(OrderDaoImpl.class);
    Connection connection;

    public OrderDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Orders> findAllByUser(int user_id) {
        String sql = "SELECT * from orders where user_id= " + user_id;
        List<Orders>  orders= new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            OrderMapper orderMapper = new OrderMapper();
            while (resultSet.next()){
                Orders order = orderMapper.extractFromResultSet(resultSet);
                orders.add(order);
            }
            logger.info("Found all orders made by user " + user_id + " list :" +orders);
            return orders;
        } catch (SQLException e) {
            logger.error(e);
            return null;
        }
    }

    @Override
    public Orders findOne(int id) {
        String sql = "SELECT * FROM orders WHERE id= " + id;
        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            OrderMapper orderMapper = new OrderMapper();
            Orders order = orderMapper.extractFromResultSet(resultSet);
            logger.info("Found order by id " + order);
            return order;
        } catch (SQLException e) {
            logger.error(e);
        }
        return null;
    }

    @Override
    public List<Orders> findAll() {
        String sql = "SELECT * from orders";
        List<Orders>  orders= new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            OrderMapper orderMapper = new OrderMapper();
            while (resultSet.next()){
                Orders order = orderMapper.extractFromResultSet(resultSet);
                orders.add(order);
            }
            logger.info("Found all orders" + orders);
            return orders;
        } catch (SQLException e) {
            logger.error(e);
            return null;
        }
    }

    @Override
    public Orders insert(Orders entity) {
        String sql = "INSERT INTO orders(user_id, total_price, date_time, waiter_id) VALUES (?, ?, ?, ?)";
        String sql_1 = "INSERT INTO order_dish(order_id, dish_id) VALUES (?, ?)";
        Date dt = new Date(entity.getDate_time().getTime());
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
        PreparedStatement stat = connection.prepareStatement(sql_1)) {
            preparedStatement.setInt(1, entity.getUser_id());
            preparedStatement.setBigDecimal(2, entity.getTotal_price());
            preparedStatement.setDate(3, dt);
            preparedStatement.setInt(4, entity.getWaiter_id());
            preparedStatement.executeUpdate();
            for (Dish dish : entity.getListOrder()) {
                stat.setInt(1, entity.getId());
                stat.setInt(2, dish.getId());
            }
            logger.info("Order " + entity + "is inserted");

            } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e);
        }
        return null;
    }

    @Override
    public boolean update(Orders entity) {
        return false;
    }

    @Override
    public boolean deleteById(int entityId) {
return false;
    }
}
