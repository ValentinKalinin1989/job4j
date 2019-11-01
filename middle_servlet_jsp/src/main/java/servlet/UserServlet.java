package servlet;

import database.DbStore;
import logic.Store;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class UserServlet extends HttpServlet {
    private final Store store = DbStore.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<User> userList = (ArrayList<User>) store.findAll();
        req.setAttribute("usersFromServer", userList);
        RequestDispatcher requestDispatcher = req.getServletContext().getRequestDispatcher("/users.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        store.delete(Integer.parseInt(req.getParameter("id")));
        doGet(req, resp);
    }
}
