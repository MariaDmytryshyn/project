package app.model.dao.mapper;

import app.model.entity.OrderDish;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDishMapper implements ObjectMapper<OrderDish> {
    @Override
    public OrderDish extractFromResultSet(ResultSet rs) throws SQLException {

        OrderDish orderDish = new OrderDish();

        orderDish.setOrder_id(rs.getInt("dish_id"));
        orderDish.setDish_id(rs.getInt("order_id"));

        return orderDish;
    }
}
