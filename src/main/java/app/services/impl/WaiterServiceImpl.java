package app.services.impl;

import app.model.dao.DaoFactory;
import app.model.dao.WaiterDao;
import app.model.dao.impl.Language;
import app.model.entity.Tables;
import app.model.entity.Waiter;
import app.services.WaiterService;

import java.util.List;

public class WaiterServiceImpl implements WaiterService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public Tables getTable(int id) {
        WaiterDao waiterDao = daoFactory.createWaiterDao();
        return waiterDao.getTable(id);
    }

    @Override
    public Waiter getWaiterByName(String name, Language language) {
        WaiterDao waiterDao = daoFactory.createWaiterDao();
        return waiterDao.getWaiterByName(name, language);
    }

    @Override
    public Waiter findOne(int id) {
        WaiterDao waiterDao = daoFactory.createWaiterDao();
        return waiterDao.findOne(id);
    }

    @Override
    public List<Waiter> findAll() {
        WaiterDao waiterDao = daoFactory.createWaiterDao();
        return waiterDao.findAll();
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
    public boolean deleteById(int entityId) {
        return false;
    }
}
