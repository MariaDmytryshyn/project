package app.commands.impl.admin;

import app.commands.Command;
import app.commands.PageName;
import app.services.Services;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindUserCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String page = PageName.SHOW_USER;
        Integer userId = Integer.parseInt(request.getParameter("userId"));
        System.out.println(Services.BILL_SERVICE.PaidByUser(userId));
        System.out.println(Services.BILL_SERVICE.UnpaidByUser(userId));
        return page;
    }
}
