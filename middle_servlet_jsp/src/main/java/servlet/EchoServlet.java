package servlet;

import logic.UsersRepositoryMemory;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class EchoServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(EchoServlet.class);

    private final UsersRepositoryMemory usersRepositoryMemory = UsersRepositoryMemory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        StringBuilder sb = new StringBuilder("<table>");
        for (User user : usersRepositoryMemory.findAll()) {
            sb.append("<tr><td>");
            sb.append(user.getLogin());
            sb.append("</td></tr>");
        }
        sb.append("</table>");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());

        StringBuilder stringBuilder = new StringBuilder("<!DOCTYPE html>");
        stringBuilder.append("<html lang=\"en\">");
        stringBuilder.append("<head>");
        stringBuilder.append("    <meta charset=\"UTF-8\">");
        stringBuilder.append("    <title>Title</title>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body>");
        stringBuilder.append("<form action = ' ");
        stringBuilder.append(req.getContextPath());
        stringBuilder.append(" /echo' method = 'post'>");
        stringBuilder.append("Name : <input type = 'text' name = 'name'/>");
        stringBuilder.append("<input type");
        stringBuilder.append("= 'submit'>");
        stringBuilder.append("</form>");
        stringBuilder.append("<br/>");
        stringBuilder.append(sb.toString());
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");
        writer.append(stringBuilder);
        writer.flush();
    }
}
