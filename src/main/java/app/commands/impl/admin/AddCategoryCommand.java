package app.commands.impl.admin;

import app.commands.Command;
import app.commands.PageName;
import app.model.entity.Category;
import app.services.Services;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCategoryCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String page = PageName.EDIT_MENU;
        String name = request.getParameter("categoryName");
        String nameEn = request.getParameter("categoryNameEN");
        Services.CATEGORY_SERVICE.insert(new Category(name, nameEn));
        return page;
    }
}
