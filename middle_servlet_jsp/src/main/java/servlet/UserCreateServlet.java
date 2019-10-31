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

public class UserCreateServlet extends HttpServlet {
    private final UsersRepositoryMemory usersRepositoryMemory = UsersRepositoryMemory.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = req.getServletContext().getRequestDispatcher("/create.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        User userToAdd = new User(usersRepositoryMemory.findAll().size() + 1,
                req.getParameter("name"),
                req.getParameter("login"),
                req.getParameter("email"),
                LocalDate.now());
        usersRepositoryMemory.add(userToAdd);
        //doGet(req, resp);
        List<User> userList = (List<User>) usersRepositoryMemory.findAll();
        req.setAttribute("usersFromServer", userList);
        RequestDispatcher requestDispatcher = req.getServletContext().getRequestDispatcher("/users.jsp");
        requestDispatcher.forward(req, resp);
    }
}
