package app.model.dao.impl;

import app.model.dao.WaiterDao;
import app.model.entity.Tables;
import app.model.entity.Waiter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.List;

public class WaiterDaoImpl implements WaiterDao {

    private static Logger logger = LogManager.getLogger(WaiterDaoImpl.class);

    Connection connection;

    public WaiterDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Tables getTable(int id) {
        return null;
    }

    @Override
    public String getNameByLanguage(int id, String language) {
        return null;
    }

    @Override
    public Waiter findOne(int id) {
        return null;
    }

    @Override
    public List<Waiter> findAll() {
        return null;
    }

    @Override
    public Waiter insert(Waiter entity) {
        return null;
    }

    @Override
    public boolean update(Waiter entity) {
        return false;
    }

    @Override
    public void deleteById(int entityId) {

    }
}
