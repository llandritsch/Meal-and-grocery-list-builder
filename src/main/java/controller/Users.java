package controller;

import persistence.UsersDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Users {


    /**
     * A simple servlet to welcome the user.
     * @author pwaite
     */

    @WebServlet(
            urlPatterns = {"/mealBuilder"}
    )

    public class SearchUser extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String lastName = req.getParameter("lastName");
            UsersDAO usersDAO = new UsersDAO();
                req.setAttribute("users", usersDAO.getAllUsers());

            RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
