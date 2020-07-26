package app.model.dao.impl;

import app.model.entity.Bill;
import app.model.entity.Waiter;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;


public class BillDaoImplTest {

    @Test
    public void insertTest() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/restaurant", "root", "root");
        BillDaoImpl billDao = new BillDaoImpl(connection);
        Bill bill = new Bill(new BigDecimal(50.00), new Date(2020, 7, 15), 1, 1, 1, Bill.BillStatus.ОПЛАЧЕНИЙ, Bill.BillStatus_En.PAID);
        bill.setWaiter(new Waiter(1, "Isas", "ff", 5));

        Bill res = billDao.insert(bill);
        assertEquals(bill, res);
    }
}
