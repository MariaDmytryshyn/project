package app.commands.impl.admin;

import app.commands.Command;
import app.commands.PageName;
import app.commands.ParameterName;
import app.model.entity.Dish;
import app.services.Services;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

public class AddDishCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String page = PageName.EDIT_MENU;
        String name = request.getParameter(ParameterName.DISH_NAME);
        String nameEn = request.getParameter(ParameterName.DISH_NAME_EN);
        BigDecimal price = new BigDecimal(request.getParameter(ParameterName.DISH_PRICE));
        Integer category = Integer.parseInt(request.getParameter(ParameterName.CATEGORY_ID));
        Dish dish = new Dish(name, nameEn, price, category);
        Services.DISH_SERVICE.insert(dish);
        return page;
    }
}
