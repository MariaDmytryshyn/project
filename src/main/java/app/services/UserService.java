package app.services;

import app.model.entity.User;

public interface UserService extends Service<User> {
    User findByLogPass(String log, String pass);
    User findByEmail(String email);
    User findByMobNum(String mobnumber);
}
