package calculator;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class OperationTest {
    @Test public void whentestPlus() {
        assertThat(SimpleOperation.PLUS.apply(5, 3), is(8.0));
    }
    @Test public void whentestMinus() {
        assertThat(SimpleOperation.MINUS.apply(5, 3), is(2.0));
    }
    @Test public void whentestTimes() {
        assertThat(SimpleOperation.TIMES.apply(5, 3), is(15.0));
    }
    @Test public void whentestDivide() {
        assertThat(SimpleOperation.DIVIDE.apply(5, 5), is(1.0));
    }

}
