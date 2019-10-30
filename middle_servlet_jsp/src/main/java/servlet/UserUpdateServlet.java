package servlet;

import logic.UsersRepositoryMemory;
import model.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class UserUpdateServlet extends HttpServlet {
    private final UsersRepositoryMemory usersRepositoryMemory = UsersRepositoryMemory.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        StringBuilder stringBuilder = new StringBuilder(" <!DOCTYPE html>");
        stringBuilder.append(" <html lang=\"en\">");
        stringBuilder.append(" <head>");
        stringBuilder.append("     <meta charset=\"UTF-8\">");
        stringBuilder.append("     <title>Title</title>");
        stringBuilder.append(" </head>");
        stringBuilder.append(" <body>");
        stringBuilder.append(" <form action = ' ");
        stringBuilder.append(req.getContextPath().concat("/update"));
        stringBuilder.append(" ' method = 'post'>");
        stringBuilder.append("Name : <input type = 'text' name = 'name' value = ");
        stringBuilder.append(req.getParameter("name"));
        stringBuilder.append(">");
        stringBuilder.append("LOGIN : <input type = 'text' name = 'login' value = ");
        stringBuilder.append(req.getParameter("login"));
        stringBuilder.append(">");
        stringBuilder.append("E-MAIL : <input type = 'text' name = 'email' value = ");
        stringBuilder.append(req.getParameter("email"));
        stringBuilder.append(">");
        stringBuilder.append("<input type = 'hidden' name = 'id' value = '");
        stringBuilder.append(req.getParameter("id"));
        stringBuilder.append("'>");
        stringBuilder.append("<input type = 'submit' value = 'SAVE'>");
        stringBuilder.append("</form>");
        stringBuilder.append("<br/>");
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");

        writer.append(stringBuilder);
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        User userToUpdate = new User(Integer.parseInt(req.getParameter("id")),
                req.getParameter("name"),
                req.getParameter("login"),
                req.getParameter("email"),
                LocalDate.now());
        usersRepositoryMemory.update(userToUpdate);
    }
}
