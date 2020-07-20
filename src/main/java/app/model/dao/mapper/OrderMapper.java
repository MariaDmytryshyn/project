package app.model.dao.mapper;

import app.model.entity.Orders;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements ObjectMapper<Orders> {
    @Override
    public Orders extractFromResultSet(ResultSet rs) throws SQLException {

        Orders order = new Orders();

        order.setId(rs.getInt("id"));
        order.setUser_id(rs.getInt("user_id"));
        order.setTotal_price(rs.getBigDecimal("total_price"));
        order.setDate_time(rs.getTimestamp("date_time"));
        order.setWaiter_id(rs.getInt("waiter_id"));

        return order;
    }
}
