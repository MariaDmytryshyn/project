package app.commands;

import java.net.http.HttpRequest;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command  {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException;
}
