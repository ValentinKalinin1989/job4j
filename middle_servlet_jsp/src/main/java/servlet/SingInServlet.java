package servlet;

import database.DbStore;
import logic.Store;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class SingInServlet extends HttpServlet {
    private final Store store = DbStore.getInstance();
    private List<User> userList = store.findAll();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("welcome", "Please, input login and password.");
        req.getRequestDispatcher("/WEB-INF/views/singin.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String role = "User";
        for (User user: userList) {
            if (login.equals(user.getLogin())) {
                role = user.getRole().toString();
                break;
            }
        }
        if (store.isCredentional(login, password)) {
            HttpSession session = req.getSession();
            session.setAttribute("login", login);
            session.setAttribute("role", role);
            resp.sendRedirect(String.format("%s/", req.getContextPath()));
        } else {
            req.setAttribute("error", "Credentional invalid. Please, input login and password. Again.");
            doGet(req, resp);
        }
    }
}

