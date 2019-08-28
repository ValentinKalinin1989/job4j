package calculator;

import calculator.operators.SumOperation;
import calculator.operators.MinusOperation;
import calculator.operators.DivideOperation;
import calculator.operators.MultipOperation;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class OperationsTest {
    @Test public void testSum() {
        assertThat(new SumOperation().operation("3 + 4"), is("7"));
        assertThat(new SumOperation().exampleOper(), is("1 + 2"));
        assertThat(new SumOperation().nameOper(), is("+"));
    }
    @Test public void testMinus() {
        assertThat(new MinusOperation().operation("3 - 4"), is("-1"));
        assertThat(new MinusOperation().exampleOper(), is("1 - 2"));
        assertThat(new MinusOperation().nameOper(), is("-"));
    }
    @Test public void testDivide() {
        assertThat(new DivideOperation().operation("3 / 4"), is("0.75"));
        assertThat(new DivideOperation().exampleOper(), is("1 / 2"));
        assertThat(new DivideOperation().nameOper(), is("/"));
    }
    @Test public void testMultip() {
        assertThat(new MultipOperation().operation("3 * 4"), is("12"));
        assertThat(new MultipOperation().exampleOper(), is("1 * 2"));
        assertThat(new MultipOperation().nameOper(), is("*"));
    }
}
