package app.commands.impl;

import app.commands.Command;
import app.commands.PageName;
import app.exceptions.HttpException;
import app.model.entity.User;
import app.services.Services;
import app.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements Command {

    private static final Logger logger = LogManager.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (login == null) {
            throw new HttpException(400, "Enter the login");
        }
        if (password == null) {
            throw new HttpException(400, "Enter the password");
        }

        UserService userService = Services.USER_SERVICE;
        if (userService.findByLog(login) == null) {
           logger.error("This user doesn't exist");
           throw new HttpException(400, "This user doesn't exist");
        }
        else {
            if (userService.findByLogPass(login, password) == null) {
                logger.error("Password is incorrect");
                throw new HttpException(400, "This password is incorrect");
            }
            User user = userService.findByLogPass(login, password);
            logger.info("User is log in");
            if (userService.findByLogPass(login, password).getRole() == User.ROLE.USER) {
                request.getSession().setAttribute("USER", user);
                return PageName.USER_MAIN;

            }
            else {
                request.getSession().setAttribute("ADMIN", user);
                return PageName.ADMIN_MAIN;
            }
        }
    }
}
