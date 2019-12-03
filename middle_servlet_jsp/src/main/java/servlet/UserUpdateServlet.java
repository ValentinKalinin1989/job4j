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
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String country = req.getParameter("country");
        String town = req.getParameter("town");
        if (name.equals("")
                || login.equals("")
                || email.equals("")
                || password.equals("")
                || req.getParameter("role").equals("")
                || country.equals("")
                || town.equals("")) {
            req.setAttribute("createError", "Input all fields");
            req.getRequestDispatcher("WEB-INF/views/update.jsp").forward(req, resp);
        } else {
            Role role = Role.valueOf(req.getParameter("role"));
            User userToUpdate = new User(Integer.parseInt(req.getParameter("id")),
                    name,
                    login,
                    email,
                    LocalDate.now(),
                    password,
                    role,
                    country,
                    town
            );
            store.update(userToUpdate);
            if (req.getSession(false).getAttribute("role").toString().equals("Admin")) {
                req.setAttribute("usersFromServer", store.findAll());
                req.getRequestDispatcher("WEB-INF/views/users.jsp").forward(req, resp);
            } else {
                req.setAttribute("user", userToUpdate);
                req.getRequestDispatcher("WEB-INF/views/onlyuser.jsp").forward(req, resp);
            }
        }
    }
}
