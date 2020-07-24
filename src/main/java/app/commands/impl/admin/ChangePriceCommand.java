package app.commands.impl.admin;

import app.commands.Command;
import app.commands.PageName;
import app.commands.ParameterName;
import app.model.entity.Dish;
import app.services.Services;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.ParagraphView;
import java.math.BigDecimal;

public class ChangePriceCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String page = PageName.EDIT_MENU;
        String name = request.getParameter(ParameterName.DISH_NAME);
        String nameEn = request.getParameter(ParameterName.DISH_NAME_EN);
        Integer category = Integer.parseInt(request.getParameter(ParameterName.CATEGORY_ID));
        BigDecimal price = new BigDecimal(request.getParameter(ParameterName.DISH_NEW_PRICE));
        Dish dish = new Dish(name, nameEn, price, category);
        Services.DISH_SERVICE.update(dish);
        return page;
    }
}
