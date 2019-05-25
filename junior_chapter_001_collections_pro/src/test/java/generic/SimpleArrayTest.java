package generic;


import java.util.Iterator;


import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {

    @Test (expected = NullPointerException.class)
    public void testSimpleArrayInteger() {
        SimpleArray<Integer> integerSimpleArray = new SimpleArray<Integer>(10);
        integerSimpleArray.add(1);
        integerSimpleArray.add(2);
        integerSimpleArray.add(3);
        integerSimpleArray.add(4);
        integerSimpleArray.add(5);
        integerSimpleArray.add(6);
        integerSimpleArray.add(7);
        integerSimpleArray.add(8);
        integerSimpleArray.add(9);
        integerSimpleArray.add(10);
        integerSimpleArray.add(11);
        assertThat(integerSimpleArray.iterator().hasNext(), is(true));
        assertThat(integerSimpleArray.iterator().hasNext(), is(true));
        assertThat(integerSimpleArray.iterator().hasNext(), is(true));
        assertThat(integerSimpleArray.iterator().next(), is(1));
        assertThat(integerSimpleArray.iterator().next(), is(2));
        assertThat(integerSimpleArray.iterator().next(), is(3));
        assertThat(integerSimpleArray.iterator().next(), is(4));
        assertThat(integerSimpleArray.iterator().next(), is(5));
        assertThat(integerSimpleArray.iterator().next(), is(6));
        assertThat(integerSimpleArray.iterator().next(), is(7));
        assertThat(integerSimpleArray.iterator().next(), is(8));
        assertThat(integerSimpleArray.iterator().next(), is(9));
        assertThat(integerSimpleArray.iterator().next(), is(10));
        assertThat(integerSimpleArray.iterator().hasNext(), is(false));
    }
}

