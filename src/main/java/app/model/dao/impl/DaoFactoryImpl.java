package app.model.dao.impl;



import app.model.dao.*;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactoryImpl extends DaoFactory {

    private Connection connection;

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
        return new OrderDaoImpl(connection);
    }

    @Override
    public TablesDao createTableDao() {
        return new TableDaoImpl(connection);
    }

    @Override
    public UserDao createUserDao() {
        return new UserDaoImpl(connection);
    }

    @Override
    public WaiterDao createWaiterDao() {
        return new WaiterDaoImpl(connection);
    }

}
