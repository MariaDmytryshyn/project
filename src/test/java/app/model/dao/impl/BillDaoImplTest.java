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
        Bill bill = new Bill(1, new BigDecimal(50.00), new Date(2020, 7, 15), 5, 8, 1, Bill.BillStatus.ОПЛАЧЕНИЙ, Bill.BillStatus_En.PAID);
        bill.setWaiter(new Waiter(1, "Isas", "ff", 5));

        Bill res = billDao.insert(bill);
        assertEquals(bill, res);
    }
//    private void testDatabase(String url) throws SQLException {
//        Connection connection= DriverManager.getConnection(url);
//        Statement s=connection.createStatement();
//        try {
//            s.execute("DROP TABLE CATEGORY");
//        } catch(SQLException sqle) {
//            System.out.println("Table not found, not dropping");
//        }
//        s.execute("CREATE TABLE CATEGORY (ID INT PRIMARY KEY, FIRSTNAME VARCHAR(64), LASTNAME VARCHAR(64))");
//        PreparedStatement ps=connection.prepareStatement("select * from PERSON");
//        ResultSet r=ps.executeQuery();
//        if(r.next()) {
//            System.out.println("data?");
//        }
//        r.close();
//        ps.close();
//        s.close();
//        connection.close();
//    }
//}
//
}
