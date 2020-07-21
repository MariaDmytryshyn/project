package app.services;

import app.model.entity.Orders;

import java.util.List;

public interface OrdersService extends Service<Orders> {
    List<Orders> findAllByUser(int user_id);
}
