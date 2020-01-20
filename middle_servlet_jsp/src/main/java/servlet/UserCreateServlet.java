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
            req.getRequestDispatcher("WEB-INF/views/create.jsp").forward(req, resp);
        } else {
            Role role = Role.valueOf(req.getParameter("role"));
            User userToAdd = new User(store.findAll().size() + 1,
                    name,
                    login,
                    email,
                    LocalDate.now(),
                    password,
                    role,
                    country,
                    town
            );
            store.add(userToAdd);
            List<User> userList = (List<User>) store.findAll();
            req.setAttribute("usersFromServer", userList);
            req.getRequestDispatcher("WEB-INF/views/users.jsp").forward(req, resp);
        }
    }
}