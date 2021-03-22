package controller;

import persistence.UsersDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class testUI {

    /**
     * Servelet to talk to UI
     * @author lisaandritsch
     */
    @WebServlet(
            urlPatterns = {"/test"})

    public class SearchUser extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            UsersDAO usersDAO = new UsersDAO();

        }
    }
}
