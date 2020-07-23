package app.commands.impl.user;

import app.commands.Command;
import app.commands.PageName;
import app.model.entity.Dish;
import app.model.entity.Orders;
import app.model.entity.User;
import app.model.entity.Waiter;
import app.services.Services;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.List;

public class ConfirmOrderCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String page = PageName.ORDER;
        List<Dish> dishes = (List<Dish>) request.getSession().getAttribute("order");
        if (dishes.isEmpty() ) {
            return page;
        }
        Orders order = new Orders();
        order.setListOrder(dishes);
        order.getTotal_price();
        long millis=System.currentTimeMillis();
        Date date = new Date(millis);
        order.setDate_time(date);
        User user = (User) request.getSession().getAttribute("USER");
        order.setUser_id(user.getId());
        Waiter waiter = (Waiter) request.getSession().getAttribute("waiter");
        order.setWaiter_id(waiter.getId());
        Services.ORDERS_SERVICE.insert(order);
        request.getSession().setAttribute("orderToPay", order);
        request.getSession().removeAttribute("order");
        return  PageName.PAY;
    }
}
