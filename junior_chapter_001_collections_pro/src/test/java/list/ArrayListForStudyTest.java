package list;

import org.junit.Test;
import org.junit.Before;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ArrayListForStudyTest {

    private ArrayListForStudy<Integer> list;

    @Before
    public void beforeTest() {
        list = new ArrayListForStudy<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

    }

    @Test
    public void whenAddTwoElementsThenUseGetOneResultTwo() {
        assertThat(list.get(0), is(1));
        assertThat(list.get(1), is(2));
        assertThat(list.get(2), is(3));
        assertThat(list.get(3), is(4));
        assertThat(list.get(4), is(5));
    }

    @Test
    public void whenTestIerator() {
        Iterator iterList = list.iterator();
        assertThat(iterList.next(), is(1));
        assertThat(iterList.next(), is(2));
        assertThat(iterList.next(), is(3));
        assertThat(iterList.next(), is(4));
        assertThat(iterList.next(), is(5));
    }

}
