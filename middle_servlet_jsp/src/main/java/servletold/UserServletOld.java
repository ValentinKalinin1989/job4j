package servletold;

import logic.UsersRepositoryMemory;
import model.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.CopyOnWriteArrayList;

public class UserServletOld extends HttpServlet {
    private final UsersRepositoryMemory usersRepositoryMemory = UsersRepositoryMemory.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        CopyOnWriteArrayList<User> userList = usersRepositoryMemory.findAll();
        PrintWriter printWriter = resp.getWriter();
        StringBuilder stringBuilder = new StringBuilder("<!DOCTYPE html> ");
        stringBuilder.append("<html lang=\"en\">");
        stringBuilder.append("<head>");
        stringBuilder.append("<meta charset=\"UTF-8\">");
        stringBuilder.append("<title>Title</title>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body>");
        stringBuilder.append("<table>");
        for (User user: userList) {
            stringBuilder.append("<tr> <form action = ' ");
            stringBuilder.append(req.getContextPath().concat("/update"));
            stringBuilder.append(" ' method = 'get'>");
            stringBuilder.append("Name : ");
            stringBuilder.append(user.getName());
            stringBuilder.append(" <input type = 'hidden' name = 'name' value = ");
            stringBuilder.append(user.getName());
            stringBuilder.append(">");
            stringBuilder.append("LOGIN : ");
            stringBuilder.append(user.getLogin());
            stringBuilder.append("  <input type = 'hidden' name = 'login' value = ");
            stringBuilder.append(user.getLogin());
            stringBuilder.append(">");
            stringBuilder.append("E-MAIL : ");
            stringBuilder.append(user.getEmail());
            stringBuilder.append(" <input type = 'hidden' name = 'email' value = ");
            stringBuilder.append(user.getEmail());
            stringBuilder.append(">");
            stringBuilder.append("<input type = 'hidden' name = 'id' value = '");
            stringBuilder.append(user.getId());
            stringBuilder.append("'>");
            stringBuilder.append("<input type = 'submit' value = 'UPDATE'>");
            stringBuilder.append("</form>");
            stringBuilder.append("<form action = ' ");
            stringBuilder.append(req.getContextPath().concat("/users"));
            stringBuilder.append(" ' method = 'post'>");
            stringBuilder.append("<input type = 'hidden' name = 'id' value = '");
            stringBuilder.append(user.getId());
            stringBuilder.append("'>");
            stringBuilder.append("<input type = 'submit' value = 'DELETE'>");
            stringBuilder.append("</form> </tr> <br/>");
        }
        stringBuilder.append("</table>");
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");
        printWriter.append(stringBuilder);
        printWriter.flush();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        usersRepositoryMemory.delete(Integer.parseInt(req.getParameter("id")));
        doGet(req, resp);
    }
}
