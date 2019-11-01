package servlet;

import database.DbStore;
import logic.Store;
import logic.UsersRepositoryMemory;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class UserUpdateServlet extends HttpServlet  {
    private final Store store = DbStore.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("WEB-INF/views/update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        User userToUpdate = new User(Integer.parseInt(req.getParameter("id")),
                req.getParameter("name"),
                req.getParameter("login"),
                req.getParameter("email"),
                LocalDate.now());
        store.update(userToUpdate);
        List<User> userList = (List<User>) store.findAll();
        req.setAttribute("usersFromServer", userList);
        req.getRequestDispatcher("WEB-INF/views/users.jsp").forward(req, resp);
    }
}
