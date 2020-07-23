package app.commands.impl.user;

import app.commands.Command;
import app.commands.PageName;
import app.exceptions.HttpException;
import app.model.entity.Category;
import app.model.entity.Dish;
import app.services.Services;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CategoryCommand implements Command {

    private static final Logger logger = LogManager.getLogger(CategoryCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        String page = PageName.CATEGORY;

        Integer categoryId = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("category_id", categoryId);
        Category category =  Services.CATEGORY_SERVICE.findOne(categoryId);

        String categoryName = category.getCategoryName();

        List<Dish> dishes = Services.DISH_SERVICE.findByCategory(categoryId);

        if (dishes != null) {
            request.setAttribute("dishes", dishes);
            request.setAttribute("categoryName", categoryName);
            logger.info("Dishes are found");
        }
        else {
            logger.error("There are no dishes");
            throw new HttpException(400, "No dishes");
        }

        return page;
    }
}
