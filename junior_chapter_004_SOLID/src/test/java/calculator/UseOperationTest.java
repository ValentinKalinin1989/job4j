package calculator;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UseOperationTest {
    @Test
    public void testMinus() {
        assertThat(UseOperation.operation("1 - 1"), is("0.0"));
    }
}
