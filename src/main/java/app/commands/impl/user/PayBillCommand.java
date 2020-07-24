package app.commands.impl.user;

import app.commands.Command;
import app.commands.PageName;
import app.commands.ParameterName;
import app.model.entity.Bill;
import app.services.Services;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PayBillCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String page = PageName.USER_MAIN;
        Integer numBill = Integer.parseInt(request.getParameter(ParameterName.BILL_ID));
        Bill bill = Services.BILL_SERVICE.findOne(numBill);
        Services.BILL_SERVICE.update(bill);
        return page;
    }
}
