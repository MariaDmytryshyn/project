package app.commands.impl;

import app.commands.Command;
import app.commands.PageName;
import app.configuration.Checker;
import app.exceptions.HttpException;
import app.model.entity.User;
import app.services.Services;
import app.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationCommand implements Command {

    private static Logger logger = LogManager.getLogger(RegistrationCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String e_mail = request.getParameter("e_mail");
        String tel = request.getParameter("mob_number");

        String page = PageName.REGISTER;
        UserService service = Services.USER_SERVICE;

        User user = new User(login, password, e_mail, tel);
        if (service.findByLogNumEmail(login, tel, e_mail) != null) {
            logger.error("User already exist");
            throw new HttpException(400, "This user already exist");
        }
        if (service.correctEmail(e_mail, Checker.REG_EX_EMAIL) && service.correctLogin(login, Checker.REG_EX_LOGIN) &&
                service.correctNumber(tel, Checker.REG_EX_MOB) && service.correctPassword(password, Checker.REG_EX_PASSWORD)) {
            service.insert(user);
            logger.info("User sucsesfully created");
            page = PageName.LOGIN;
        } else {
            logger.info("Input is incorrect");
            throw new HttpException(400, "The input is incorrect. Mobile number must contain 10 numbers. Password must contain " +
                    "upper and lower letters without spaces and have at least 8 characters. Login must have at least 8 characters. Email should be real.");
        }
        return page;
    }
}
