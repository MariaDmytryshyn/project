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
            while (resultSet.next()) {
                User user = userMapper.extractFromResultSet(resultSet);
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> findAll() {
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
    public void deleteById(int entityId) {

    }
}
