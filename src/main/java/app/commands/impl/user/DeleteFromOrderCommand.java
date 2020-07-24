package app.commands.impl.user;

import app.commands.Command;
import app.commands.PageName;
import app.commands.ParameterName;
import app.model.entity.Dish;
import app.services.Services;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class DeleteFromOrderCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        String page = PageName.ORDER;
        int dishToRemove = Integer.parseInt(request.getParameter(ParameterName.ID_DELETE));
        Dish dish = Services.DISH_SERVICE.findOne(dishToRemove);
        List<Dish> dishes = (List<Dish>) request.getSession(false).getAttribute(ParameterName.ORDER);
        dishes.remove(dish);
        request.getSession(false).setAttribute(ParameterName.ORDER, dishes);
        return page;

    }
}
