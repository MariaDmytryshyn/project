package app.model.dao.mapper;

import app.model.entity.Bill;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BillMapper implements ObjectMapper<Bill> {
    @Override
    public Bill extractFromResultSet(ResultSet rs) throws SQLException {

        Bill bill = new Bill();

        bill.setId(rs.getInt("id"));
        bill.setPrice(rs.getBigDecimal("price"));
        bill.setDate_time(rs.getDate("date_time"));
        bill.setOder_id(rs.getInt("order_id"));
        bill.setUser_id(rs.getInt("user_id"));
        bill.setWaiter_id(rs.getInt("waiter_id"));
        bill.setBillStatus(Bill.BillStatus.valueOf(rs.getString("status").toUpperCase()));
        bill.setBillStatus_en(Bill.BillStatus_En.valueOf(rs.getString("status_en").toUpperCase()));

        return bill;

    }
}
