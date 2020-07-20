package app.model.dao.impl;

import app.model.dao.CategoryDao;

import app.model.dao.mapper.CategoryMapper;

import app.model.entity.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    private Connection connection;

    public CategoryDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Category findOne(int id) {
        String sql = "SELECT * FROM category WHERE id= " + id;
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            CategoryMapper categoryMapper = new CategoryMapper();
            while (resultSet.next()) {
                Category category = categoryMapper.extractFromResultSet(resultSet);
                return category;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Category> findAll() {
        String sql = "SELECT * from category";
        List<Category> categories = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            CategoryMapper categoryMapper = new CategoryMapper();
            while (resultSet.next()) {
                Category category = categoryMapper.extractFromResultSet(resultSet);
                categories.add(category);
            }
            return categories;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Category insert(Category entity) {
        String sql = "INSERT INTO category(name, name_en) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, entity.getCategoryName());
            preparedStatement.setString(2, entity.getCategoryName_en());
            if (preparedStatement.executeUpdate() > 0) {
                return entity;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Category entity) {
        return false;
    }


    @Override
    public void deleteById(int entityId) {
        String sql = "delete from category where  id=" + entityId;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            int res = statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
