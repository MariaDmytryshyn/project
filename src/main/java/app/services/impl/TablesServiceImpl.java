package app.services.impl;

import app.model.dao.DaoFactory;
import app.model.dao.TablesDao;
import app.model.entity.Tables;
import app.model.entity.Waiter;
import app.services.TablesService;

import java.util.List;

public class TablesServiceImpl implements TablesService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public Tables findOne(int id) {
        TablesDao tablesDao = daoFactory.createTableDao();
        return tablesDao.findOne(id);
    }

    @Override
    public List<Tables> findAll() {
        TablesDao tablesDao = daoFactory.createTableDao();
        return tablesDao.findAll();
    }

    @Override
    public Tables insert(Tables entity) {
        return null;
    }

    @Override
    public boolean update(Tables entity) {
        TablesDao tablesDao = daoFactory.createTableDao();
        return tablesDao.update(entity);
    }

    @Override
    public boolean deleteById(int entityId) {
        return false;
    }

    @Override
    public List<Tables> findFree() {
        TablesDao tablesDao = daoFactory.createTableDao();
        return tablesDao.findFree();
    }

    @Override
    public Waiter findWaiter(Tables entity) {
        TablesDao tablesDao = daoFactory.createTableDao();
        return tablesDao.findWaiter(entity);
    }
}
