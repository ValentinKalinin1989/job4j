package servlet;

import com.google.gson.Gson;
import database.DbStore;
import logic.Store;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class GetTownsServlet extends HttpServlet {
    private final Store store = DbStore.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> list = store.getTowns(req.getParameter("contry"));
        resp.setContentType("json");
        resp.getWriter().write(new Gson().toJson(list));
    }
}
