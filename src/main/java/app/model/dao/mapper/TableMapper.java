package app.model.dao.mapper;

import app.model.entity.Tables;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TableMapper implements ObjectMapper<Tables> {
    @Override
    public Tables extractFromResultSet(ResultSet rs) throws SQLException {

        Tables table = new Tables();

        table.setTablesId(rs.getInt("id"));
        table.setTablesNumber(rs.getInt("number"));
        table.setIs_free(rs.getBoolean("is_free"));

        return table;
    }
}
