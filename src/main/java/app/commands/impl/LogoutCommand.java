package app.commands.impl;

import app.commands.Command;
import app.commands.PageName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutCommand implements Command {

    private static final Logger logger = LogManager.getLogger(LogoutCommand.class);

    @Override
    public String  execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        request.getSession().invalidate();
        logger.info("You successfully logged out");
        return PageName.INDEX;
    }
}
