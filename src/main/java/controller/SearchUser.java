package controller;

import persistence.UsersDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */
@WebServlet(
        urlPatterns = {"/searchUser"})

public class SearchUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsersDAO usersDAO = new UsersDAO();
        req.setAttribute("users", usersDAO.getAllUsers());
        RequestDispatcher dispatcher = req.getRequestDispatcher("displayUsers.jsp");
        dispatcher.forward(req, resp);
    }
}

