package app.model.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Bill {

    private int id;
    private BigDecimal price;
    private Date date_time;
    private int oder_id;
    private int user_id;
    private int waiter_id;

    public enum BillStatus {
        ОПЛАЧЕНИЙ, НЕОПЛАЧЕНИЙ;
    }

    public enum BillStatus_En {
        PAID, UNPAIND;
    }

    private BillStatus billStatus;
    private  BillStatus_En billStatus_en;

    private User user;
    private Waiter waiter;

    public Bill() {
    }

    public Bill(BigDecimal price, Date date_time, int oder_id, int user_id, int waiter_id, BillStatus billStatus, BillStatus_En billStatus_en) {
        this.price = price;
        this.date_time = date_time;
        this.oder_id = oder_id;
        this.user_id = user_id;
        this.waiter_id = waiter_id;
        this.billStatus = billStatus;
        this.billStatus_en = billStatus_en;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getDate_time() {
        return date_time;
    }

    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }

    public int getOder_id() {
        return oder_id;
    }

    public void setOder_id(int oder_id) {
        this.oder_id = oder_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getWaiter_id() {
        return waiter_id;
    }

    public void setWaiter_id(int waiter_id) {
        this.waiter_id = waiter_id;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }

    public BillStatus_En getBillStatus_en() {
        return billStatus_en;
    }

    public void setBillStatus_en(BillStatus_En billStatus_en) {
        this.billStatus_en = billStatus_en;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return id == bill.id &&
                oder_id == bill.oder_id &&
                user_id == bill.user_id &&
                waiter_id == bill.waiter_id &&
                price.equals(bill.price) &&
                date_time.equals(bill.date_time) &&
                billStatus == bill.billStatus &&
                billStatus_en == bill.billStatus_en;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, date_time, oder_id, user_id, waiter_id, billStatus, billStatus_en,  user, waiter);
    }

    @Override
    public String toString() {
        return "Bill number is " + id +
                ", price is " + price +
                ", date_time is " + date_time +
                ", billStatus is " + billStatus +
                ", billStatus_en is " + billStatus_en +
                ", user is (" + user +
                "), waiter is (" + waiter + ")";
    }
}

