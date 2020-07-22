package app.services;

import app.model.entity.User;

public interface UserService extends Service<User> {
    User findByLogNumEmail(String log, String number, String email);
    User findByLogPass(String login, String password);
    User findByLog(String login);
    boolean correctEmail(String email, String ex);
    boolean correctPassword(String password, String ex);
    boolean correctLogin(String login, String ex);
    boolean correctNumber(String number, String ex);
}
