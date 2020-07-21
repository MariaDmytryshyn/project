package app.model.dao.impl;

import app.model.dao.UserDao;
import app.model.dao.mapper.UserMapper;
import app.model.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    public User findByLogPass(String log, String pass) {
        String sql = "SELECT * FROM user WHERE login =" + log + " and password=" + pass;
        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            UserMapper userMapper = new UserMapper();
            User user = userMapper.extractFromResultSet(resultSet);
            logger.info("User found " + user  + " with login " + log + " and password " + pass);
            return user;
        } catch (SQLException e) {
            logger.error(e);
        }
        return null;
    }

    @Override
    public User findByEmail(String email) {
        String sql = "SELECT * FROM user WHERE e_mail =" + email;
        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            UserMapper userMapper = new UserMapper();
            User user = userMapper.extractFromResultSet(resultSet);
            logger.info("User found " + user  + " with email " + email);
            return user;
        } catch (SQLException e) {
            logger.error(e);
        }
        return null;
    }

    @Override
    public User findByMobNum(String mobnumber) {
        String sql = "SELECT * FROM user WHERE mob_number =" + mobnumber;
        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            UserMapper userMapper = new UserMapper();
            User user = userMapper.extractFromResultSet(resultSet);
            logger.info("User found " + user  + " with mobile number " + mobnumber);
            return user;
        } catch (SQLException e) {
            logger.error(e);
        }
        return null;
    }
}
