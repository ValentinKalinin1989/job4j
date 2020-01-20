package servlet;

import json.JsonUser;
import json.JsonUserMapInMemory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import servletjson.JSONservlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.concurrent.ConcurrentHashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@PowerMockIgnore({"com.sun.org.apache.xerces.*", "javax.xml.*", "org.xml.*", "org.w3c.*", "javax.management.*"})
@RunWith(PowerMockRunner.class)
@PrepareForTest(JsonUserMapInMemory.class)
public class TestJSONServlet {
    @Test
    public void whenGetJsonDataFromServer() throws ServletException, IOException {
        JsonUserMapInMemory mapJson = new JsonUserMapInMemory();
        PowerMockito.mockStatic(JsonUserMapInMemory.class);
        Mockito.when(JsonUserMapInMemory.getInstance()).thenReturn(mapJson);
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        String test = "{\n"
                + "\"name\":  \"TestName\",\n"
                + "\"surname\": \"TestSurname\",\n"
                + "\"descrip\": \"TEstDescription\",\n"
                + "\"sex\": \"Male\"\n"
                + " }";
        Reader inputString = new StringReader(test);
        BufferedReader reader = new BufferedReader(inputString);
        when(request.getReader()).thenReturn(reader);
        new JSONservlet().doPost(request, response);
        ConcurrentHashMap map = mapJson.getMap();
        JsonUser user = (JsonUser) map.values().iterator().next();
        assertThat(user.getName(), is("TestName"));
        assertThat(user.getSurname(), is("TestSurname"));
        assertThat(user.getDescrip(), is("TEstDescription"));
        assertThat(user.getSex(), is("Male"));
    }
}
