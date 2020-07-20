package app.model.dao.mapper;

import app.model.entity.Category;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements ObjectMapper<Category> {
    @Override
    public Category extractFromResultSet(ResultSet rs) throws SQLException {

        Category category = new Category();

        category.setCategoryId(rs.getInt("id"));
        category.setCategoryName(rs.getString("name"));
        category.setCategoryName_en(rs.getString("name_en"));

        return category;
    }
}
