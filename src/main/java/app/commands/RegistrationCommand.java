package app.commands;

import app.configuration.Checker;
import app.exceptions.HttpException;
import app.model.entity.User;
import app.services.Services;
import app.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegistrationCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String e_mail = request.getParameter("e_mail");
        String tel = request.getParameter("mob_number");

        HttpSession httpSession = request.getSession(true);

        UserService service = Services.USER_SERVICE;

        User user = new User(login, password, e_mail, tel);
        if (service.findByLogNumEmail(login, tel, e_mail) != null) {
            httpSession.setAttribute("userAlreadyExist", true);
            throw new HttpException(400, "This user already exist");
        }
        if (service.correctEmail(e_mail, Checker.REG_EX_EMAIL) && service.correctLogin(login, Checker.REG_EX_LOGIN) &&
                service.correctNumber(tel, Checker.REG_EX_MOB) && service.correctPassword(password, Checker.REG_EX_PASSWORD)) {
            service.insert(user);
            httpSession.setAttribute("createdUser", user);
        } else {
            httpSession.setAttribute("userNotCreated", true);
            throw new HttpException(400, "The input is incorrect. Mobile number must contain 10 numbers. Password must contain " +
                    "upper and lower letters without spaces and have at least 8 characters. Login must have at least 8 characters. Email should be real.");
        }
    }
}
