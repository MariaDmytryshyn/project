package app.commands.impl.user;

import app.commands.Command;
import app.commands.PageName;
import app.commands.ParameterName;
import app.model.entity.Tables;
import app.model.entity.Waiter;
import app.services.Services;
import app.services.TablesService;
import app.services.WaiterService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SelectTableCommand implements Command {

    private static final Logger logger = LogManager.getLogger(SelectTableCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String page = PageName.ORDER;
        TablesService tablesService = Services.TABLES_SERVICE;
        List<Tables> tables = tablesService.findFree();
       if (tables.isEmpty()) {
           page = PageName.ALL_RESERVED;
           logger.info("All tables are reserved");
       }
       Tables table = tables.get(0);
       tablesService.update(table);
       Waiter waiter = tablesService.findWaiter(table);
       WaiterService waiterService = Services.WAITER_SERVICE;
       waiterService.update(waiter);
       request.getSession(false).setAttribute(ParameterName.TABLE, table);
       request.getSession(false).setAttribute(ParameterName.WAITER, waiter);
        return page;
    }
}
