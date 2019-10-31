package servlet;

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
    private final UsersRepositoryMemory usersRepositoryMemory = UsersRepositoryMemory.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = req.getServletContext().getRequestDispatcher("/update.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        User userToUpdate = new User(Integer.parseInt(req.getParameter("id")),
                req.getParameter("name"),
                req.getParameter("login"),
                req.getParameter("email"),
                LocalDate.now());
        usersRepositoryMemory.update(userToUpdate);
        List<User> userList = (List<User>) usersRepositoryMemory.findAll();
        req.setAttribute("usersFromServer", userList);
        RequestDispatcher requestDispatcher = req.getServletContext().getRequestDispatcher("/users.jsp");
        requestDispatcher.forward(req, resp);
    }
}
