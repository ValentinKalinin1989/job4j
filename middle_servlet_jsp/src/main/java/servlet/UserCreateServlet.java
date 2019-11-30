package servlet;

import database.DbStore;
import logic.Store;
import model.Role;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class UserCreateServlet extends HttpServlet {
    private final Store store = DbStore.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        if (req.getSession(false).getAttribute("role").toString().equals("Admin")) {
            req.setAttribute("countries", (ArrayList<String>) store.getCountries());
            req.getRequestDispatcher("/WEB-INF/views/create.jsp").forward(req, resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        User userToAdd = new User(store.findAll().size() + 1,
                req.getParameter("name"),
                req.getParameter("login"),
                req.getParameter("email"),
                LocalDate.now(),
                req.getParameter("password"),
                Role.valueOf(req.getParameter("role")),
                req.getParameter("country"),
                req.getParameter("town")
        );
        store.add(userToAdd);
        List<User> userList = (List<User>) store.findAll();
        req.setAttribute("usersFromServer", userList);
        req.getRequestDispatcher("WEB-INF/views/users.jsp").forward(req, resp);
    }
}