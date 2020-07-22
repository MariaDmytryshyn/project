package app.commands;

import app.exceptions.HttpException;
import app.model.entity.User;
import app.services.Services;
import app.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCommand implements Command {

    private static final Logger logger = LogManager.getLogger(LoginCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String number = request.getParameter("mob_number");
        if (login == null) {
            throw new HttpException(400, "Enter the login");
        }
        if (password == null) {
            throw new HttpException(400, "Enter the password");
        }
        if (email == null) {
            throw new HttpException(400, "Enter the email");
        }
        if (number == null) {
            throw new HttpException(400, "Enter the mobile phone");
        }
        UserService userService = Services.USER_SERVICE;
        if (userService.findByLogNumEmail(login, number, email) == null) {
           logger.error("This user doesn't exist");
           throw new HttpException(400, "This user doesn't exist");
        }
        else {
            HttpSession session = request.getSession(true);
            if (userService.findByLogNumEmail(login, number, email).getPassword() != password) {
                session.setAttribute("notLoggedIn", true);
                logger.error("Password is incorrect");
                throw new HttpException(400, "This password is incorrect");
            }
            logger.info("User is log in");
            if (userService.findByLogNumEmail(login, number, email).getRole() == User.ROLE.ADMIN) {
                session.setAttribute("typeOfUser", "ADMIN");
            }
            else {
                session.setAttribute("typeOfUser", "USER");
            }
            session.setAttribute("user", userService.findByLogNumEmail(login, number, email));

        }
    }
}
