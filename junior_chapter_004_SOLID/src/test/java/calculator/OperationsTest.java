package calculator;

import calculator.operators.SumOperation;
import calculator.operators.MinusOperation;
import calculator.operators.DivideOperation;
import calculator.operators.MultipOperation;
import calculator.operators.SinOperation;
import calculator.operators.CosOperation;
import calculator.operators.TanOperation;

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
    @Test public void testSin() {
        assertThat(new SinOperation().operation("sin 30"), is("-0.9880316240928618"));
        assertThat(new SinOperation().exampleOper(), is("sin 45"));
        assertThat(new SinOperation().nameOper(), is("sin"));
    }
    @Test public void testCos() {
        assertThat(new CosOperation().operation("cos 60"), is("-0.9524129804151563"));
        assertThat(new CosOperation().exampleOper(), is("cos 45"));
        assertThat(new CosOperation().nameOper(), is("cos"));
    }
    @Test public void testTan() {
        assertThat(new TanOperation().operation("tan 45"), is("1.6197751905438615"));
        assertThat(new TanOperation().exampleOper(), is("tan 45"));
        assertThat(new TanOperation().nameOper(), is("tan"));
    }
}
