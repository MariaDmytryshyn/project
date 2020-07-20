package app.model.dao.impl;


import app.configuration.DBCPDataSource;
import app.model.dao.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactoryImpl extends DaoFactory {

    Connection connection;

    {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/restaurant", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public BillDao createBillDao() {
        return new BillDaoImpl(connection);
    }

    @Override
    public CategoryDao createCategoryDao() {
        return new CategoryDaoImpl(connection);
    }

    @Override
    public DishDao createDishDao() {
        return new DishDaoImpl(connection);
    }

    @Override
    public OrderDishDao createOrderDishDao() {
        return new OrderDishDaoImpl(connection);
    }

    @Override
    public OrdersDao createOrderDao() {
        return null;
    }

    @Override
    public TablesDao createTableDao() {
        return null;
    }

    @Override
    public UserDao createUserDao() {
        return null;
    }

    @Override
    public WaiterDao createWaiterDao() {
        return null;
    }

}
