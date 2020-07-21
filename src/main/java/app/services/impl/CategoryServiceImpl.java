package app.services.impl;

import app.model.dao.CategoryDao;
import app.model.dao.DaoFactory;
import app.model.entity.Category;
import app.services.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public Category findOne(int id) {
        CategoryDao categoryDao = daoFactory.createCategoryDao();
        return categoryDao.findOne(id);
    }

    @Override
    public List<Category> findAll() {
        CategoryDao categoryDao = daoFactory.createCategoryDao();
        return categoryDao.findAll();
    }

    @Override
    public Category insert(Category entity) {
        CategoryDao categoryDao = daoFactory.createCategoryDao();
        return categoryDao.insert(entity);
    }

    @Override
    public boolean update(Category entity) {
        return false;
    }

    @Override
    public boolean deleteById(int entityId) {
        CategoryDao categoryDao = daoFactory.createCategoryDao();
        return categoryDao.deleteById(entityId);
    }
}
