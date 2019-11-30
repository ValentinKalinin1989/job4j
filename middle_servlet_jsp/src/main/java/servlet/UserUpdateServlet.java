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

public class UserUpdateServlet extends HttpServlet  {
    private final Store store = DbStore.getInstance();
    private List<User> userList = store.findAll();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setAttribute("countries", (ArrayList<String>) store.getCountries());
        req.getRequestDispatcher("WEB-INF/views/update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        User userToUpdate = new User(Integer.parseInt(req.getParameter("id")),
                req.getParameter("name"),
                req.getParameter("login"),
                req.getParameter("email"),
                LocalDate.now(),
                req.getParameter("password"),
                Role.valueOf(req.getParameter("role")),
                req.getParameter("country"),
                req.getParameter("town")
        );
        store.update(userToUpdate);
        List<User> userList = (List<User>) store.findAll();
        if (req.getSession(false).getAttribute("role").toString().equals("Admin")) {
            req.setAttribute("usersFromServer", userList);
            req.getRequestDispatcher("WEB-INF/views/users.jsp").forward(req, resp);
        } else {
            req.setAttribute("user", userToUpdate);
            req.getRequestDispatcher("WEB-INF/views/onlyuser.jsp").forward(req, resp);
        }
    }
}
