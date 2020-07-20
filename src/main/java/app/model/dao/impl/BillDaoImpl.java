package app.model.dao.impl;

import app.model.dao.BillDao;
import app.model.dao.mapper.BillMapper;
import app.model.entity.Bill;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillDaoImpl implements BillDao {

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
            return bills;
        } catch (SQLException e) {
            e.printStackTrace();
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
            return bills;
        } catch (SQLException e) {
            e.printStackTrace();
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
            return bills;
        } catch (SQLException e) {
            e.printStackTrace();
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
            return bills;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Bill findOne(int id) {
        String sql = "SELECT * FROM bill WHERE id= " + id;
        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            BillMapper billMapper = new BillMapper();
            while (resultSet.next()) {
                Bill bill = billMapper.extractFromResultSet(resultSet);
                return bill;
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
            return bills;
        } catch (SQLException e) {
            e.printStackTrace(); }
        return null;
    }

    @Override
    public Bill insert(Bill entity) {
        String sql = "INSERT INTO bill(price, date_time, order_id, user_id, waiter_id, status, status_en) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Date dt = new Date(entity.getDate_time().getTime());
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setBigDecimal(1, entity.getPrice());
            preparedStatement.setDate(2, dt);
            preparedStatement.setInt(3, entity.getOder_id());
            preparedStatement.setInt(4, entity.getUser().getId());
            preparedStatement.setInt(5, entity.getWaiter().getId());
            preparedStatement.setString(6, entity.getBillStatus().toString());
            preparedStatement.setString(7, entity.getBillStatus_en().toString());
            if (preparedStatement.executeUpdate() > 0) {
                return entity;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Bill entity) {
        String sql = "UPDATE bill SET status = 'оплачений', status_en = 'paid'  WHERE id=" + entity.getId();
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            return (statement.executeUpdate(sql)>0);
            } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }


    @Override
    public void deleteById(int entityId) {

    }
}
