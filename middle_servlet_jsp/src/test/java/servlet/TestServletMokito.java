package servlet;

import com.google.gson.Gson;
import database.DbStore;
import logic.Store;
import logic.UsersRepositoryMemory;
import model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@PowerMockIgnore({"com.sun.org.apache.xerces.*", "javax.xml.*", "org.xml.*", "org.w3c.*", "javax.management.*"})
@RunWith(PowerMockRunner.class)
@PrepareForTest(UsersRepositoryMemory.class)
public class TestServletMokito {
    @Test
    public void whenAddUserThenDbStoreIt() throws ServletException, IOException {
        UsersRepositoryMemory dbStore = new UsersRepositoryMemory();
        PowerMockito.mockStatic(UsersRepositoryMemory.class);
        Mockito.when(UsersRepositoryMemory.getInstance()).thenReturn(dbStore);
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        when(request.getParameter("name")).thenReturn("Jonh Dow");
        when(request.getParameter("login")).thenReturn("kilchen");
        when(request.getParameter("email")).thenReturn("kitchen_kit@mail.ru");
        when(request.getParameter("password")).thenReturn("qwerty228");
        when(request.getParameter("role")).thenReturn("User");
        when(request.getParameter("country")).thenReturn("Russia");
        when(request.getParameter("town")).thenReturn("Tomsk");
        when(request.getRequestDispatcher("WEB-INF/views/users.jsp")).thenReturn(requestDispatcher);
        new UserCreateServletReposInMem().doPost(request, response);
        List<User> userList = dbStore.findAll();
        User addedUser = null;
        for (User user : userList) {
            if (user.getName().equals("Jonh Dow")) {
                addedUser = user;
                break;
            }
        }
        assertThat(addedUser.getName(), is("Jonh Dow"));
        assertThat(addedUser.getLogin(), is("kilchen"));
        assertThat(addedUser.getEmail(), is("kitchen_kit@mail.ru"));
        assertThat(addedUser.getPassword(), is("qwerty228"));
        assertThat(addedUser.getRole().toString(), is("User"));
    }


    @Test
    public void justTest() {
        Store store = DbStore.getInstance();
        List<String> list = store.getTowns("Russia");
        for (String string : list) {
            System.out.println(string);
        }
        System.out.println(new Gson().toJson(list));
    }


}
