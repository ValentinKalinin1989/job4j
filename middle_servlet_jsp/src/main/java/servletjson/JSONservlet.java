package servletjson;

import com.fasterxml.jackson.databind.ObjectMapper;
import json.JsonUser;
import json.JsonUserMapInMemory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

public class JSONservlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    private JsonUserMapInMemory jsonMap = JsonUserMapInMemory.getInstance();
    private static final Logger LOG = LogManager.getLogger(JSONservlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/htmls/index.html").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        LOG.info("Получение данных");
        StringBuilder stringBuilder = new StringBuilder();
        reader.lines().forEach(stringBuilder::append);
        String str = stringBuilder.toString();
        LOG.info("Считывание данных");
        JsonUser jsonUser = objectMapper.readValue(stringBuilder.toString(), JsonUser.class);
        jsonMap.addJsonUser(jsonUser);
        LOG.info("Данные сохранены");
    }
}
