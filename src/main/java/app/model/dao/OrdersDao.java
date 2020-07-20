package app.model.dao;

import app.model.entity.Orders;

import java.util.List;

public interface OrdersDao extends Dao<Orders> {
    List<Orders> findAllByUser(int user_id);
}
