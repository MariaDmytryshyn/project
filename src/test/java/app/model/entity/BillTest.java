package app.model.entity;

import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class BillTest {

    private Bill bill = new Bill(new BigDecimal(58.00), new Timestamp(new GregorianCalendar(2020, 7, 1).getTimeInMillis()), 5, 3, 7, Bill.BillStatus.ОПЛАЧЕНИЙ, Bill.BillStatus_En.PAID);


    @Test
    public void getIdTest() {
        bill.setId(3);
        assertEquals(3, bill.getId());
    }

    @Test
    public void setIdTest() {
        bill.setId(12);
        assertEquals(12, bill.getId());
    }

    @Test
    public void getPriceTest() {
        assertEquals(new BigDecimal(58.00), bill.getPrice());
    }

    @Test
    public void setPriceTest() {
        bill.setPrice(new BigDecimal(48.00));
        assertEquals(new BigDecimal(48.00), bill.getPrice());
    }

    @Test
    public void getDate_TimeTest() {
        assertEquals(new Timestamp(new GregorianCalendar(2020, 7, 1).getTimeInMillis()), bill.getDate_time());
    }

    @Test
    public void setDate_TimeTest() {
        bill.setDate_time(new Timestamp(new GregorianCalendar(2014, 3, 24).getTimeInMillis()));
        assertEquals(new Timestamp(new GregorianCalendar(2014, 3, 24).getTimeInMillis()), bill.getDate_time());
    }

    @Test
    public void getOrder_idTest() {
        assertEquals(5, bill.getOder_id());
    }

    @Test
    public void setOrder_idTest() {
        bill.setOder_id(17);
        assertEquals(17, bill.getOder_id());
    }

    @Test
    public void getUser_idTest() {
        assertEquals(3, bill.getUser_id());
    }

    @Test
    public void setUser_idTest() {
        bill.setUser_id(7);
        assertEquals(7, bill.getUser_id());
    }

    @Test
    public void getWaiter_idTest() {
        assertEquals(7, bill.getWaiter_id());
    }

    @Test
    public void setWaiter_idTest() {
        bill.setWaiter_id(11);
        assertEquals(11, bill.getWaiter_id());
    }

    @Test
    public void getStatusTest() {
        assertEquals(Bill.BillStatus.ОПЛАЧЕНИЙ, bill.getBillStatus());
    }

    @Test
    public void setStatusTest() {
        bill.setBillStatus(Bill.BillStatus.ОПЛАЧЕНИЙ);
        assertEquals(Bill.BillStatus.ОПЛАЧЕНИЙ, bill.getBillStatus());
    }

    @Test
    public void getStatus_enTest() {
        assertEquals(Bill.BillStatus_En.PAID, bill.getBillStatus_en());
    }

    @Test
    public void setStatus_enTest() {
        bill.setBillStatus_en(Bill.BillStatus_En.UNPAIND);
        assertEquals(Bill.BillStatus_En.UNPAIND, bill.getBillStatus_en());
    }

    @Test
    public void hashCodeTest() {
        Bill bill1 = new Bill();
        Bill bill2 = new Bill();
        bill1.setId(1);
        bill2.setId(1);
        assertEquals(bill1.hashCode(), bill2.hashCode());
    }

    @Test
    public void equalsTest() {
        Bill bill1 = new Bill(new BigDecimal(45.00), new Timestamp(new GregorianCalendar(2020, 4, 2).getTimeInMillis()), 2, 5, 10, Bill.BillStatus.ОПЛАЧЕНИЙ, Bill.BillStatus_En.PAID);
        Bill bill2 = new Bill(new BigDecimal(45.00), new Timestamp(new GregorianCalendar(2020, 4, 2).getTimeInMillis()), 2, 5, 10, Bill.BillStatus.ОПЛАЧЕНИЙ, Bill.BillStatus_En.PAID);
        assertEquals(true, bill1.equals(bill2));
    }

    @Test
    public void toStringTest() {
        Bill bill = new Bill(new BigDecimal(45.00), new Timestamp(new GregorianCalendar(2020, 4, 2).getTimeInMillis()), 2, 5, 10, Bill.BillStatus.ОПЛАЧЕНИЙ, Bill.BillStatus_En.PAID);
        User user = new User("Viki27", "vikakolos", "kolos_v@gmail.com", "0975643789");
        bill.setUser(user);
        bill.setId(1);
        user.setId(2);
        Waiter waiter = new Waiter(1, "Марта Наконечна", "Marta Nakonechna", 10);
        bill.setWaiter(waiter);
        assertEquals("Bill number is 1, price is 45, date_time is 2020-05-02 00:00:00.0, billStatus is ОПЛАЧЕНИЙ, billStatus_en is PAID, user is (User id is 2, login is Viki27', password is vikakolos', e-mail is kolos_v@gmail.com, mobile number is 0975643789), waiter is (Waiter name is Марта Наконечна', name_en is Marta Nakonechna', table number is 10)", bill.toString());
    }

    @Test
    public void UserTest() {
        bill.setUser(new User("Viki27", "vikakolos", "kolos_v@gmail.com", "0975643789"));
        assertEquals(new User("Viki27", "vikakolos", "kolos_v@gmail.com", "0975643789"), bill.getUser());
    }

    @Test
    public void WaiterTest() {
        bill.setWaiter(new Waiter(10, "Марта Наконечна", "Marta Nakonechna", 10 ));
        assertEquals(new Waiter(10, "Марта Наконечна", "Marta Nakonechna", 10), bill.getWaiter());

    }


}
