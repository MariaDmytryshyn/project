package app.services.impl;

import app.model.dao.DaoFactory;
import app.model.dao.UserDao;
import app.model.entity.User;
import app.services.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public User findByLogPass(String log, String pass) {
        UserDao userDao = daoFactory.createUserDao();
        return  userDao.findByLogPass(log, pass);
    }

    @Override
    public User findByEmail(String email) {
        UserDao userDao = daoFactory.createUserDao();
        return  userDao.findByEmail(email);
    }

    @Override
    public User findByMobNum(String mobnumber) {
        UserDao userDao = daoFactory.createUserDao();
        return  userDao.findByMobNum(mobnumber);
    }

    @Override
    public User findOne(int id) {
        UserDao userDao = daoFactory.createUserDao();
        return  userDao.findOne(id);
    }

    @Override
    public List<User> findAll() {
        UserDao userDao = daoFactory.createUserDao();
        return  userDao.findAll();
    }

    @Override
    public User insert(User entity) {
        UserDao userDao = daoFactory.createUserDao();
        return  userDao.insert(entity);
    }

    @Override
    public boolean update(User entity) {
        return false;
    }

    @Override
    public boolean deleteById(int entityId) {
        return false;
    }
}
