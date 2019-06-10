package map;

import org.junit.Test;
import org.junit.Before;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleHashMapTest {
    private SimpleHashMap<Integer, Integer> map;

    @Before
    public void beforeTest() {
        map = new SimpleHashMap<>();
        map.insert(1, 1);
        map.insert(2, 2);
        map.insert(3, 3);
        map.delete(2);
    }

    @Test
    public void whenInsertTreeElementAndGetTwo() {
        assertThat(map.get(1), is(1));
        assertThat(map.get(3), is(3));
    }

    @Test
    public void whenTestIterator() {
        Iterator iterator = map.iterator();
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(3));
    }
}
