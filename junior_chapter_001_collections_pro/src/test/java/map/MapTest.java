package map;

import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class MapTest {


    private Map<User, Object> map = new HashMap<>();

    @Before
    public void beforeTestAddTwoUsersInMap() {
        map.put(new User("Федя", 2, new GregorianCalendar(1989, 1, 4)),
                "Федя");
        map.put(new User("Федя", 2, new GregorianCalendar(1989, 1, 4)),
                "Федя");
    }


    @Test
    public void whenPrintMap() {
        System.out.printf(map.toString());
    }
}
