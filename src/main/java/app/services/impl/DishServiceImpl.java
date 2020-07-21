package app.services.impl;

import app.model.dao.DaoFactory;
import app.model.dao.DishDao;
import app.model.dao.impl.Language;
import app.model.entity.Dish;
import app.services.DishService;

import java.util.List;

public class DishServiceImpl implements DishService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public List<Dish> findByCategory(int categoy_id) {
        DishDao dishDao = daoFactory.createDishDao();
        return dishDao.findByCategory(categoy_id);
    }

    @Override
    public Dish findByName(String name, Language language) {
        DishDao dishDao = daoFactory.createDishDao();
        return dishDao.findByName(name, language);
    }

    @Override
    public Dish findOne(int id) {
        DishDao dishDao = daoFactory.createDishDao();
        return dishDao.findOne(id);
    }

    @Override
    public List<Dish> findAll() {
        DishDao dishDao = daoFactory.createDishDao();
        return dishDao.findAll();
    }

    @Override
    public Dish insert(Dish entity) {
        DishDao dishDao = daoFactory.createDishDao();
        return dishDao.insert(entity);
    }

    @Override
    public boolean update(Dish entity) {
        DishDao dishDao = daoFactory.createDishDao();
        return dishDao.update(entity);
    }

    @Override
    public boolean deleteById(int entityId) {
        DishDao dishDao = daoFactory.createDishDao();
        return dishDao.deleteById(entityId);
    }
}
