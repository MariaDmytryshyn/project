package app.commands.impl.user;

import app.commands.Command;
import app.commands.PageName;
import app.exceptions.HttpException;
import app.model.entity.Category;
import app.services.CategoryService;
import app.services.Services;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MenuCommand implements Command {

    private static final Logger logger = LogManager.getLogger(MenuCommand.class);
    private static final CategoryService getAllCategories = Services.CATEGORY_SERVICE;


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String page = PageName.MENU;
        List<Category> categoryList = getAllCategories.findAll();
        if (categoryList != null)  {
            logger.info("Categories are found");
            request.setAttribute("categories", categoryList);
        }
        else {
            logger.error("Categories aren't found");
            throw new HttpException(400, "There is no categories");
        }
        return page;
    }
}
