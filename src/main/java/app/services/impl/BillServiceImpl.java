package app.services.impl;

import app.model.dao.BillDao;
import app.model.dao.DaoFactory;
import app.model.entity.Bill;
import app.services.BillService;

import java.util.List;

public class BillServiceImpl implements BillService {

    DaoFactory daoFactory = DaoFactory.getInstance();


    @Override
    public List<Bill> findUnpaid() {
        BillDao billDao = daoFactory.createBillDao();
        return billDao.findUnpaid();
    }

    @Override
    public List<Bill> findPaid() {
        BillDao billDao = daoFactory.createBillDao();
        return billDao.findPaid();
    }

    @Override
    public List<Bill> UnpaidByUser(int user_id) {
        BillDao billDao = daoFactory.createBillDao();
        return billDao.UnpaidByUser(user_id);
    }

    @Override
    public List<Bill> PaidByUser(int user_id) {
        BillDao billDao = daoFactory.createBillDao();
        return billDao.PaidByUser(user_id);
    }

    @Override
    public Bill findOne(int id) {
        BillDao billDao = daoFactory.createBillDao();
        return billDao.findOne(id);
    }

    @Override
    public List<Bill> findAll() {
        BillDao billDao = daoFactory.createBillDao();
        return billDao.findAll();
    }

    @Override
    public Bill insert(Bill entity) {
        BillDao billDao = daoFactory.createBillDao();
        return billDao.insert(entity);
    }

    @Override
    public boolean update(Bill entity) {
        BillDao billDao = daoFactory.createBillDao();
        return billDao.update(entity);
    }

    @Override
    public boolean deleteById(int entityId) {
        return false;
    }
}
