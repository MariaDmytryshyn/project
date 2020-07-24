package app.controller;


import app.commands.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class Servlet extends HttpServlet {
    public static final long serialVersionUID = 1;

    public Servlet() {
        super();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }


    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding(ParameterName.UTF8);
        String commandName = request.getParameter(ParameterName.COMMAND_NAME);

        Command command = CommandFactory.getInstance().getCommand(Commands.valueOf(commandName));

        String page;

        page = command.execute(request, response);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);

        if (requestDispatcher != null) {
            requestDispatcher.forward(request, response);
        }
    }
}