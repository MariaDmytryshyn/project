package app.commands.impl.admin;

import app.commands.Command;
import app.commands.PageName;
import app.services.Services;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteDishCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String page = PageName.EDIT_MENU;
        Integer dishId = Integer.parseInt(request.getParameter("dishId"));
        Services.DISH_SERVICE.deleteById(dishId);
        return page;
    }
}
