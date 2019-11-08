package servletold;

import logic.UsersRepositoryMemory;
import model.Role;
import model.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class UserCreateServletOld extends HttpServlet {
    private final UsersRepositoryMemory usersRepositoryMemory = UsersRepositoryMemory.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = new PrintWriter(resp.getOutputStream());

        StringBuilder stringBuilder = new StringBuilder("<!DOCTYPE html>");
        stringBuilder.append("<html lang=\"en\">");
        stringBuilder.append("<head>");
        stringBuilder.append("<meta charset=\"UTF-8\">");
        stringBuilder.append("<title>Title</title>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body>");
        stringBuilder.append("<form action = ' ");
        stringBuilder.append(req.getContextPath().concat("/create"));
        stringBuilder.append(" ' method = 'post'>");
        stringBuilder.append("Name : <input type = 'text' name = 'name'/>");
        stringBuilder.append("LOGIN : <input type = 'text' name = 'login'/>");
        stringBuilder.append("E-MAIL : <input type = 'text' name = 'email'/>");
        stringBuilder.append("<input type = 'submit'>");
        stringBuilder.append("</form>");
        stringBuilder.append("<br/>");
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");

        writer.append(stringBuilder);
        writer.flush();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User userToAdd = new User(usersRepositoryMemory.findAll().size() + 1,
                req.getParameter("name"),
                req.getParameter("login"),
                req.getParameter("email"),
                LocalDate.now(),
                req.getParameter("password"),
                Role.valueOf(req.getParameter("role")));
        usersRepositoryMemory.add(userToAdd);
        doGet(req, resp);
    }
}
