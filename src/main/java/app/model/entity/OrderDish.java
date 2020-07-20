package app.model.entity;

import java.util.ArrayList;

public class OrderDish {

    private int order_id;
    private int dish_id;

    private Orders order;
    private ArrayList<Dish> dishes;

    public OrderDish() {
    }

    public OrderDish(int order_id, int dish_id) {
        this.order_id = order_id;
        this.dish_id = dish_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getDish_id() {
        return dish_id;
    }

    public void setDish_id(int dish_id) {
        this.dish_id = dish_id;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(ArrayList<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        return "OrderDish" +
                ", order is" + order.toString() +
                ", dishes=" + dishes.toString();
    }
}
