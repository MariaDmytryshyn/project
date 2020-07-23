package app.model.dao.impl;

import app.model.dao.TablesDao;
import app.model.dao.mapper.OrderMapper;
import app.model.dao.mapper.TableMapper;
import app.model.dao.mapper.WaiterMapper;
import app.model.entity.Orders;
import app.model.entity.Tables;
import app.model.entity.Waiter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TableDaoImpl implements TablesDao {

    Connection connection;
    private static Logger logger = LogManager.getLogger(TableDaoImpl.class);

    public TableDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Tables findOne(int id) {
        String sql = "SELECT * FROM tables WHERE id= " + id;
        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            TableMapper tableMapper = new TableMapper();
            resultSet.next();
            Tables table = tableMapper.extractFromResultSet(resultSet);
            logger.info("Found table by id " + table);
            return table;

        } catch (SQLException e) {
            logger.error(e);
        }
        return null;
    }

    @Override
    public List<Tables> findAll() {
        String sql = "SELECT * from tables";
        List<Tables>  tables= new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            TableMapper tableMapper = new TableMapper();
            while (resultSet.next()){
                Tables table = tableMapper.extractFromResultSet(resultSet);
                tables.add(table);
            }
            logger.info("Found all tables" + tables);
            return tables;
        } catch (SQLException e) {
            logger.error(e);
            return null;
        }
    }

    @Override
    public Tables insert(Tables entity) {
        return null;
    }

    @Override
    public boolean update(Tables entity) {

        String sql = "UPDATE tables SET is_free = false  where id=" + entity.getTablesId();
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            boolean res = statement.executeUpdate(sql)>0;
            if (res == true ) {
                logger.info("Table is updated");
            }
            else {
                logger.info("Table is not updated");
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

    @Override
    public List<Tables> findFree() {
        String sql = "SELECT * from tables where is_free = 0 ";
        List<Tables>  tables= new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            TableMapper tableMapper = new TableMapper();
            while (resultSet.next()){
                Tables table = tableMapper.extractFromResultSet(resultSet);
                tables.add(table);
            }
            logger.info("Found all free tables" + tables);
            return tables;
        } catch (SQLException e) {
            logger.error(e);
            return null;
        }
    }

    @Override
    public Waiter findWaiter(Tables entity) {
        String sql = "SELECT * from waiter where table_id = " + entity.getTablesId();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            WaiterMapper waiterMapper = new WaiterMapper();
            Waiter waiter = waiterMapper.extractFromResultSet(resultSet);
            logger.info("Found waiter " + waiter);
            return waiter;
        } catch (SQLException e) {
            logger.error(e);
            return null;
        }
    }
}
