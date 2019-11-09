package servlet;

import database.DbStore;
import model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@PowerMockIgnore({"com.sun.org.apache.xerces.*", "javax.xml.*", "org.xml.*", "org.w3c.*", "javax.management.*", "java.lang.NullPointerException"})
@RunWith(PowerMockRunner.class)
@PrepareForTest(DbStore.class)
public class TestServletMokito {
    @Test
    public void whenAddUserThenDbStoreIt() throws ServletException, IOException {
        DbStore dbStore = new DbStore();
        PowerMockito.mockStatic(DbStore.class);
        Mockito.when(DbStore.getInstance()).thenReturn(dbStore);
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("name")).thenReturn("Jonh Dow");
        when(request.getParameter("login")).thenReturn("kilchen");
        when(request.getParameter("email")).thenReturn("kitchen_kit@mail.ru");
        when(request.getParameter("password")).thenReturn("qwerty228");
        when(request.getParameter("role")).thenReturn("User");
        new UserCreateServlet().doPost(request, response);
        List<User> userList = dbStore.findAll();
        User addedUser = null;
        for (User user: userList) {
            if (user.getName().equals("Jonh Dow")) {
                addedUser = user;
                break;
            }
        }
        User userTest = dbStore.findAll().iterator().next();
        assertThat(addedUser.getName(), is("Jonh Dow"));
        assertThat(addedUser.getLogin(), is("kilchen"));
        assertThat(addedUser.getEmail(), is("kitchen_kit@mail.ru"));
        assertThat(addedUser.getPassword(), is("qwerty228"));
        assertThat(addedUser.getRole().toString(), is("User"));
    }

}
