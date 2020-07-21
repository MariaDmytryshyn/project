package app.model.dao;

import app.model.entity.User;

public interface UserDao extends Dao<User> {
    User findByLogPass(String log, String pass);
    User findByEmail(String email);
    User findByMobNum(String mobnumber);

}
