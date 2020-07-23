package app.model.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Orders {

    private int id;
    private int user_id;
    private BigDecimal total_price;
    private Date date_time;
    private int waiter_id;
    private Waiter waiter;
    private User user;
    private List<Dish> listOrder;
    private Bill bill;

    public Orders() {
    }

    public Orders(Timestamp date_time, int waiter_id, int user_id, List<Dish> listOrder) {
        this.date_time = date_time;
        this.waiter_id = waiter_id;
        this.user_id = user_id;
        this.listOrder = listOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public BigDecimal getTotal_price() {
        this.total_price = new BigDecimal(0);
        for(Dish dish:listOrder) {
            total_price = total_price.add(dish.getPrice());
        }
        return total_price;
    }

    public void setTotal_price(BigDecimal price) {
        this.total_price = price;
    }

    public Date getDate_time() {
        return date_time;
    }

    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }

    public int getWaiter_id() {
        return waiter_id;
    }

    public void setWaiter_id(int waiter_id) {
        this.waiter_id = waiter_id;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Dish> getListOrder() {
        return listOrder;
    }

    public void setListOrder(List<Dish> listOrder) {
        this.listOrder = listOrder;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return id == orders.id &&
                user_id == orders.user_id &&
                waiter_id == orders.waiter_id &&
                total_price.equals(orders.total_price) &&
                date_time.equals(orders.date_time) &&
                waiter.equals(orders.waiter) &&
                user.equals(orders.user) &&
                listOrder.equals(orders.listOrder) &&
                bill.equals(orders.bill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_id, total_price, date_time, waiter_id, waiter, user, listOrder, bill);
    }

    @Override
    public String toString() {
        return "Order" +
                " total_price is" + total_price +
                ", date is " + date_time +
                ", waiter is" + waiter.toString() +
                ", user is " + user.toString() +
                ", listOrder is " + listOrder.toString() +
                ", bill is " + bill.toString();
    }
}

