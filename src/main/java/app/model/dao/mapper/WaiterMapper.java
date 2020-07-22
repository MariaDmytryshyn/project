package app.model.dao.mapper;

import app.model.entity.Waiter;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WaiterMapper implements ObjectMapper<Waiter> {
    @Override
    public Waiter extractFromResultSet(ResultSet rs) throws SQLException {

        Waiter waiter = new Waiter();

        waiter.setId(rs.getInt("id"));
        waiter.setName(rs.getString("name"));
        waiter.setName_en(rs.getString("name_en"));
        waiter.setTable_id(rs.getInt("table_id"));

        return waiter;
    }
}
