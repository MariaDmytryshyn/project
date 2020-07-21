package app.model.dao.impl;

import app.model.dao.CategoryDao;

import app.model.dao.mapper.CategoryMapper;

import app.model.entity.Category;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    private static Logger logger = LogManager.getLogger(CategoryDaoImpl.class);

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
            Category category = categoryMapper.extractFromResultSet(resultSet);
            logger.info("Found category " +category);
            return category;
        } catch (SQLException e) {
            logger.error(e);
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
            logger.info("Found all categories " + categories);
            return categories;
        } catch (SQLException e) {
            logger.error(e);
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
                logger.info("Category is inserted " + entity);
                return entity;
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        return null;
    }

    @Override
    public boolean update(Category entity) {
        return false;
    }


    @Override
    public boolean deleteById(int entityId) {
        String sql = "delete from category where  id=" + entityId;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            boolean res = statement.executeUpdate(sql) > 0;
            if ( res == true) {
                logger.info("Category is deleted");
            }
            else {
                logger.info("Category is not deleted");
            }
            return res;

        } catch (SQLException e) {
            logger.error(e);
        }
        return false;
    }
}
