package app.model.dao.impl;

import app.model.dao.WaiterDao;
import app.model.dao.mapper.TableMapper;
import app.model.dao.mapper.WaiterMapper;
import app.model.entity.Tables;
import app.model.entity.Waiter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WaiterDaoImpl implements WaiterDao {

    private static Logger logger = LogManager.getLogger(WaiterDaoImpl.class);

    private Connection connection;

    public WaiterDaoImpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public Waiter getWaiterByName(String name, Language language) {
        String sql = "";
        if (language == Language.ENGLISH) {
            sql = "SELECT * FROM waiter WHERE name_en =" + name;
        }
        else {
            sql = "SELECT * FROM waiter WHERE name =" + name;
        }
        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            WaiterMapper waiterMapper = new WaiterMapper();
            resultSet.next();
            Waiter waiter = waiterMapper.extractFromResultSet(resultSet);
            logger.info("Found waiter " + waiter);
            return waiter;
        }
         catch (SQLException e) {
            logger.error(e);
        }
        return null;
    }

    @Override
    public Waiter findOne(int id) {
        String sql = "SELECT * FROM waiter WHERE id =" + id;
        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            WaiterMapper waiterMapper = new WaiterMapper();
            resultSet.next();
            Waiter waiter = waiterMapper.extractFromResultSet(resultSet);
            logger.info("Found  waiter " + waiter);
            return waiter;

        } catch (SQLException e) {
            logger.error(e);
        }
        return null;
    }

    @Override
    public List<Waiter> findAll() {
        String sql = "SELECT * FROM waiter";
        try (Statement statement = connection.createStatement()){
            List<Waiter> waiters = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery(sql);
            WaiterMapper waiterMapper = new WaiterMapper();
            while (resultSet.next()) {
                Waiter waiter = waiterMapper.extractFromResultSet(resultSet);
                waiters.add(waiter);
            }
            logger.info("Found  waiters " + waiters);
            return waiters;

        } catch (SQLException e) {
            logger.error(e);
        }
        return null;
    }

    @Override
    public Waiter insert(Waiter entity) {
        return null;
    }

    @Override
    public boolean update(Waiter entity) {
        String sql = "UPDATE waiter SET is_free = false  where id=" + entity.getId();
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            boolean res = statement.executeUpdate(sql)>0;
            if (res == true ) {
                logger.info("Waiter is updated");
            }
            else {
                logger.info("Waiter is not updated");
            }
            return res;
        } catch (SQLException ex) {
            logger.error(ex);
        }
        return false;
    }

    @Override
    public boolean deleteById(int entityId) {
        return false;
    }
}
