package app.commands.impl.user;

import app.commands.Command;
import app.commands.PageName;
import app.model.entity.Bill;
import app.model.entity.Orders;
import app.model.entity.User;
import app.services.Services;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

public class ShowBillCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String page = PageName.PAY;
        Orders order = (Orders) request.getSession().getAttribute("orderToPay");
        Bill bill = new Bill(order.getTotal_price(), order.getDate_time(), order.getId(), order.getUser_id(), order.getWaiter_id(), Bill.BillStatus.НЕОПЛАЧЕНИЙ, Bill.BillStatus_En.UNPAIND);
        request.setAttribute("UnpaidBills", Services.BILL_SERVICE.UnpaidByUser(order.getUser_id()));
        System.out.println("Your unpaid bills are " + Services.BILL_SERVICE.UnpaidByUser(order.getUser_id()));
        return page;
    }
}
