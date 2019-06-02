package list;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleQueueTest {

    private SimpleQueue<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleQueue<>();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);
    }

    @Test
    public void whenPollAllElementAndGet12345() {
        assertThat(list.poll(), is(1));
        assertThat(list.poll(), is(2));
        assertThat(list.poll(), is(3));
        assertThat(list.poll(), is(4));
        assertThat(list.poll(), is(5));
        list.push(6);
        assertThat(list.poll(), is(6));
    }

}
