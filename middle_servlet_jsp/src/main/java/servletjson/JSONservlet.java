package servletjson;

import com.fasterxml.jackson.databind.ObjectMapper;
import json.JsonUser;
import json.JsonUserMapInMemory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

public class JSONservlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    private final JsonUserMapInMemory jsonMap = new JsonUserMapInMemory();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/htmls/index.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        reader.lines().forEach(stringBuilder::append);
        JsonUser jsonUser = objectMapper.readValue(stringBuilder.toString(), JsonUser.class);
        jsonMap.addJsonUser(jsonUser);
        req.setAttribute("jsonUser", jsonUser);
    }
}
