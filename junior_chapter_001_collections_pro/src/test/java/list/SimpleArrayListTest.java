package list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayListTest {

    private SimpleArrayList<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.delete();
    }

    @Test
    public void whenAddThreeElementsDelOneElementThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(1));
        assertThat(list.get(0), is(2));
    }

    @Test
    public void whenAddThreeElementsDelOneElementThenUseGetSizeResultTwo() {
        assertThat(list.getSize(), is(2));
    }

    @Test
    public void whenGetDellElement() {
        assertThat(list.delete(), is(2));
    }


}
