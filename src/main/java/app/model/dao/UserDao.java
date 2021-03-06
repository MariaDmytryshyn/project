package app.model.dao;

import app.model.entity.User;

public interface UserDao extends Dao<User> {
    User findByLogNumEmail(String log, String number, String email);
    User findByLogPass(String login, String password);
    User findByLog(String login);

}
