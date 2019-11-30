package servlet;

import database.DbStore;
import logic.Store;
import model.User;

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
        User userThisLoggin = null;
        if (req.getSession(false).getAttribute("role").toString().equals("Admin")) {
            req.setAttribute("usersFromServer", userList);
            req.getRequestDispatcher("/WEB-INF/views/users.jsp").forward(req, resp);
        } else {
            for (User user: userList) {
                if (req.getSession(false).getAttribute("login").toString().equals(user.getLogin())) {
                    userThisLoggin = user;
                    break;
                }
            }
            req.setAttribute("user", userThisLoggin);
            req.getRequestDispatcher("/WEB-INF/views/onlyuser.jsp").forward(req, resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        store.delete(Integer.parseInt(req.getParameter("id")));
        doGet(req, resp);
    }
}
