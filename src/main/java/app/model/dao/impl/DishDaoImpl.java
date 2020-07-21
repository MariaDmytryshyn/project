package app.model.dao.impl;

import app.model.dao.DishDao;

import app.model.dao.mapper.DishMapper;

import app.model.entity.Dish;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DishDaoImpl implements DishDao {

    private static Logger logger = LogManager.getLogger(DishDaoImpl.class);

    Connection connection;

    public DishDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Dish> findByCategory(int categoy_id) {
        String sql = "SELECT * from dish where category_id= " + categoy_id;
        List<Dish> dishes= new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            DishMapper dishMapper = new DishMapper();
            while (resultSet.next()){
                Dish dish = dishMapper.extractFromResultSet(resultSet);
                dishes.add(dish);
            }
            logger.info("Found all dishes " + dishes + " from category " + categoy_id);
            return dishes;
        } catch (SQLException e) {
            logger.error(e);
            return null;
        }
    }

    @Override
    public Dish findByName(String name, Language language) {
        String sql = "";
        if (language == Language.ENGLISH) {
            sql = "SELECT * from dish where name_en= " + name;
        }else {
            sql = "SELECT * from dish where name =  " + name;
        }
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            DishMapper dishMapper = new DishMapper();
            resultSet.next();
            Dish dish = dishMapper.extractFromResultSet(resultSet);
            logger.info("Found dish " + dish + " by name " + name);
            return dish;
        } catch (SQLException e) {
            logger.error(e);
        }
        return null;
    }

    @Override
    public Dish findOne(int id) {
        String sql = "SELECT * FROM dish WHERE id= " + id;
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            DishMapper dishMapper = new DishMapper();
            resultSet.next();
            Dish dish = dishMapper.extractFromResultSet(resultSet);
            logger.info("Fond dish " + dish);
            return dish;
        } catch (SQLException e) {
            logger.error(e);
        }
        return null;
    }

    @Override
    public List<Dish> findAll() {
        String sql = "SELECT * from dish ";
        List<Dish> dishes= new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            DishMapper dishMapper = new DishMapper();
            while (resultSet.next()){
                Dish dish = dishMapper.extractFromResultSet(resultSet);
                dishes.add(dish);
            }
            logger.info("Found all dishes " + dishes);
            return dishes;
        } catch (SQLException e) {
            logger.error(e);
            return null;
        }
    }

    @Override
    public Dish insert(Dish entity) {
        String sql = "INSERT INTO dish(name, name_en, price, category_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getName_en());
            preparedStatement.setBigDecimal(3, entity.getPrice());
            preparedStatement.setInt(4, entity.getCategory_id());
            if (preparedStatement.executeUpdate() > 0) {
                logger.info("Dish is inserted " + entity);
                return entity;
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        return null;
    }

    @Override
    public boolean update(Dish entity) {
        String sql = "UPDATE dish SET price =" + entity.getPrice() +"  WHERE id=" + entity.getId();
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            boolean res  = statement.executeUpdate(sql)>0;
            if ( res == true) {
                logger.info("Dish is updated " + entity);
            }
            else {
                logger.info("Dish is not updated " + entity);
            }
            return res;
        } catch (SQLException ex) {
            logger.error(ex);
        }
        return false;
    }

    @Override
    public boolean deleteById(int entityId) {
        String sql = "delete from dish where  id=" + entityId;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            boolean res = statement.executeUpdate(sql) > 0;
            if ( res == true) {
                logger.info("Dish is deleted ");
            }
            else {
                logger.info("Dish is not deleted " );
            }
            return res;
        } catch (SQLException e) {
            logger.error(e);
        }
        return false;
    }

}
