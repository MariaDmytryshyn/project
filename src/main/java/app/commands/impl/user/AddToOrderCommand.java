package app.commands.impl.user;

import app.commands.Command;
import app.commands.PageName;
import app.commands.ParameterName;
import app.model.entity.Dish;
import app.services.Services;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class AddToOrderCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        String page = PageName.ORDER;

        int dish_id = Integer.parseInt(request.getParameter(ParameterName.DISH_ID));

        List<Dish> dishes = (List<Dish>) request.getSession(false).getAttribute(ParameterName.ORDER);

        if (dishes == null) {
            dishes = new ArrayList<>();
        }

        Dish dish = Services.DISH_SERVICE.findOne(dish_id);
        dishes.add(dish);

        request.getSession(false).setAttribute(ParameterName.ORDER, dishes);

        return  page;
    }
}
