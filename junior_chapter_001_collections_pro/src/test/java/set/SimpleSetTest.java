package set;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


import java.util.Iterator;

public class SimpleSetTest {
    private SimpleSet<Integer> set;

    @Before
    public void beforeTest() {
        set = new SimpleSet<>();
        set.add(1);
        set.add(1);
        set.add(2);
        set.add(2);
        set.add(2);
        set.add(3);
        set.add(3);
        set.add(3);
        set.add(4);
    }

    @Test
    public void whenTestIteratorAndGetNoDoubleInSet() {
        Iterator iteratorSet = set.iterator();
        assertThat(iteratorSet.next(), is(1));
        assertThat(iteratorSet.next(), is(2));
        assertThat(iteratorSet.next(), is(3));
        assertThat(iteratorSet.next(), is(4));
    }
}
