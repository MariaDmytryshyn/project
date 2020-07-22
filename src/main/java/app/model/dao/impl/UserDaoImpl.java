package app.model.dao.impl;

import app.model.dao.UserDao;
import app.model.dao.mapper.UserMapper;
import app.model.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    Connection connection;
    private static Logger logger = LogManager.getLogger(TableDaoImpl.class);

    public UserDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User findOne(int id) {
        String sql = "SELECT * FROM user WHERE id= " + id;
        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            UserMapper userMapper = new UserMapper();
            resultSet.next();
            User user = userMapper.extractFromResultSet(resultSet);
            logger.info("User found " + user);
            return user;
        } catch (SQLException e) {
            logger.error(e);
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM user ";
        try (Statement statement = connection.createStatement()){
            List<User> users = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery(sql);
            UserMapper userMapper = new UserMapper();
            while (resultSet.next()) {
                User user = userMapper.extractFromResultSet(resultSet);
                users.add(user);
            }
            logger.info("All users are found " + users);
        } catch (SQLException e) {
            logger.error(e);
        }
        return null;
    }

    @Override
    public User insert(User entity) {
        String sql = "INSERT INTO user(name, login, password, e_mail, mob_number, role) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getLogin());
            preparedStatement.setString(3, entity.getPassword());
            preparedStatement.setString(4, entity.getE_mail());
            preparedStatement.setString(5, entity.getMob_number());
            preparedStatement.setString(6, entity.getRole().toString());
            if (preparedStatement.executeUpdate() > 0) {
                logger.info("User is inserted");
                return entity;
            }
        }
        catch (SQLException e) {
            logger.error(e);
        }
        return null;
    }

    @Override
    public boolean update(User entity) {
        return false;
    }

    @Override
    public boolean deleteById(int entityId) {
return false;
    }

    @Override
    public User findByLogNumEmail(String log, String number, String email) {
        String sql = "SELECT * FROM user WHERE login =" + log + " and e_mail=" + email + " and mob_number=" + number;
        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            UserMapper userMapper = new UserMapper();
            User user = userMapper.extractFromResultSet(resultSet);
            logger.info("User found " + user  + " with login " + log + " and email " + email + " and with number " + number);
            return user;
        } catch (SQLException e) {
            logger.error(e);
        }
        return null;
    }




}
