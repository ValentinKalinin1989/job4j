package servlet;

import logic.UsersRepositoryMemory;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.concurrent.ConcurrentSkipListSet;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private final UsersRepositoryMemory usersRepositoryMemory = UsersRepositoryMemory.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ConcurrentSkipListSet<User> userList = usersRepositoryMemory.findAll();
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("<h1>" + "List of users." + "</h1>");
        for (User user: userList) {
            printWriter.write("<h2>" + user.toString() + "</h2>");
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String typeOperation = req.getParameter("action");
        if (typeOperation.equals("add")) {
            int id = usersRepositoryMemory.findAll().size() + 1;
            usersRepositoryMemory.add(getUserOfParam(id, req));
        }
        if (typeOperation.equals("update")) {
            int id = Integer.parseInt(req.getParameter("id"));
            usersRepositoryMemory.update(id, getUserOfParam(id, req));
        }
        if (typeOperation.equals("delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            usersRepositoryMemory.delete(id);
        }
    }
    private User getUserOfParam(int id, HttpServletRequest req) {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        LocalDate createDate = LocalDate.parse(req.getParameter("email"));
        return new User(id, name, login, email, createDate);
    }


}
