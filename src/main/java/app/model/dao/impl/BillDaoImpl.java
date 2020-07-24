package app.model.dao.impl;

import app.model.dao.BillDao;
import app.model.dao.mapper.BillMapper;
import app.model.entity.Bill;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillDaoImpl implements BillDao {

    private static Logger logger = LogManager.getLogger(BillDaoImpl.class);

    private Connection connection;

    public BillDaoImpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public List<Bill> findUnpaid() {
        String sql = "SELECT * from bill where status='не оплачений' ";
        List<Bill> bills= new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            BillMapper billMapper = new BillMapper();
            while (resultSet.next()){
                Bill bill = billMapper.extractFromResultSet(resultSet);
                bills.add(bill);
            }
            logger.info("Found all unpaid bills" + bills);
            return bills;
        } catch (SQLException e) {
            logger.error("e");
            return null;
        }
    }

    @Override
    public List<Bill> findPaid() {
        String sql = "SELECT * from bill where status='оплачений' ";
        List<Bill> bills= new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            BillMapper billMapper = new BillMapper();
            while (resultSet.next()){
                Bill bill = billMapper.extractFromResultSet(resultSet);
                bills.add(bill);
            }
            logger.info("Found all paid bills " + bills);
            return bills;
        } catch (SQLException e) {
           logger.error(e);
            return null;
        }
    }

    @Override
    public List<Bill> UnpaidByUser(int user_id) {
        String sql = "SELECT * from bill where user_id =" + user_id +" and status = 'не оплачений'";
        List<Bill> bills= new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            BillMapper billMapper = new BillMapper();
            while (resultSet.next()){
                Bill bill = billMapper.extractFromResultSet(resultSet);
                bills.add(bill);
            }
            logger.info("Found all unpaid bills " + bills + " by user " + user_id);
            return bills;
        } catch (SQLException e) {
            logger.error(e);
            return null;
        }
    }

    @Override
    public List<Bill> PaidByUser(int user_id){
        String sql = "SELECT * from bill where user_id =" + user_id +" and status = 'оплачений'";
        List<Bill> bills= new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            BillMapper billMapper = new BillMapper();
            while (resultSet.next()){
                Bill bill = billMapper.extractFromResultSet(resultSet);
                bills.add(bill);
            }
            logger.info("Found all paid bills " + bills + " by user " + user_id);
            return bills;
        } catch (SQLException e) {
            logger.error(e);
            return null;
        }
    }

    @Override
    public Bill findOne(int id) {
        String sql = "SELECT * FROM bill WHERE id= " + id;
        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            BillMapper billMapper = new BillMapper();
            resultSet.next();
            Bill bill = billMapper.extractFromResultSet(resultSet);
            logger.info("Found bill " + bill);
            return bill;
        } catch (SQLException e) {
            logger.error(e);
        }
        return null;
    }

    @Override
    public List<Bill> findAll() {
        String sql = "SELECT * FROM bill";
        try (Statement statement = connection.createStatement()) {
            List<Bill> bills = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery(sql);
            BillMapper billMapper = new BillMapper();
            while (resultSet.next()) {
                Bill bill = billMapper.extractFromResultSet(resultSet);
                bills.add(bill);}
            logger.info("All bills found " + bills);
            return bills;
        } catch (SQLException e) {
            logger.error(e); }
        return null;
    }

    @Override
    public Bill insert(Bill entity) {
        String sql = "INSERT INTO bill(price, date_time, order_id, user_id, waiter_id) VALUES (?, ?, ?, ?, ?)";
        Date dt = new Date(entity.getDate_time().getTime());
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setBigDecimal(1, entity.getPrice());
            preparedStatement.setDate(2, dt);
            preparedStatement.setInt(3, entity.getOder_id());
            preparedStatement.setInt(4, entity.getUser().getId());
            preparedStatement.setInt(5, entity.getWaiter().getId());
            if (preparedStatement.executeUpdate() > 0) {
                logger.info("Bill is inserted");
                return entity;
            }
        }
        catch (SQLException e) {
            logger.error(e);
        }
        return null;
    }

    @Override
    public boolean update(Bill entity) {
        String sql = "UPDATE bill SET status = 'оплачений', status_en = 'paid'  WHERE id=" + entity.getId();
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            boolean res = statement.executeUpdate(sql)>0;
            if (res == true ) {
                logger.info("Bill is updated");
            }
            else {
                logger.info("Bill is not updated");
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
