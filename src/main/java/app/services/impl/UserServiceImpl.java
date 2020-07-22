package app.services.impl;

import app.model.dao.DaoFactory;
import app.model.dao.UserDao;
import app.model.entity.User;
import app.services.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public User findByLogNumEmail(String log, String number, String email) {
        UserDao userDao = daoFactory.createUserDao();
        return  userDao.findByLogNumEmail(log, number, email);
    }

    @Override
    public boolean correctEmail(String email, String ex) {
        return email.matches(ex);
    }

    @Override
    public boolean correctPassword(String password, String ex) {
        return password.matches(ex);
    }

    @Override
    public boolean correctLogin(String login, String ex) {
        return login.matches(ex);
    }

    @Override
    public boolean correctNumber(String number, String ex) {
        return number.matches(ex);
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
