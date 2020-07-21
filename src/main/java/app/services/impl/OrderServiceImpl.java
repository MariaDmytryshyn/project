package app.services.impl;

import app.model.dao.DaoFactory;
import app.model.dao.OrdersDao;
import app.model.entity.Orders;
import app.services.OrdersService;

import java.util.List;

public class OrderServiceImpl implements OrdersService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public List<Orders> findAllByUser(int user_id) {
        OrdersDao ordersDao = daoFactory.createOrderDao();
        return ordersDao.findAllByUser(user_id);
    }

    @Override
    public Orders findOne(int id) {
        OrdersDao ordersDao = daoFactory.createOrderDao();
        return ordersDao.findOne(id);
    }

    @Override
    public List<Orders> findAll() {
        OrdersDao ordersDao = daoFactory.createOrderDao();
        return ordersDao.findAll();
    }

    @Override
    public Orders insert(Orders entity) {
        OrdersDao ordersDao = daoFactory.createOrderDao();
        return ordersDao.insert(entity);
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
