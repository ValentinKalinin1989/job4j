package map;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class MapTest {

    public class User {
        private String name;
        private int children;
        private Calendar birthday;

        public User(String name, int children, Calendar birthday) {
            this.name = name;
            this.children = children;
            this.birthday = birthday;
        }

    }

    private Map<User, Object> map = new HashMap<>();

    @Before
    public void beforeTestAddTwoUsersInMap() {
       map.put(new User("Федя", 2, new GregorianCalendar(1989, 1, 4)), "Федя");
       map.put(new User("Ваня", 2, new GregorianCalendar(2001, 12, 9)), "Ваня");
    }


    @Test
    public void whenPrintMap() {
        System.out.printf(map.toString());
    }
}
