package ru.job4j.fuction;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class FunctionTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionTask function = new FunctionTask();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenLinearQuadratic() {
        FunctionTask function = new FunctionTask();
        List<Double> result = function.diapason(5, 8, x -> 2 * x * x + 1);
        List<Double> expected = Arrays.asList(51D, 73D, 99D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogaritFunctionThenLogaritResults() {
        FunctionTask function = new FunctionTask();
        List<Double> result = function.diapason(5, 8, x -> 2 * Math.log(x) / Math.log(x) + 1);
        List<Double> expected = Arrays.asList(3D, 3D, 3D);
        assertThat(result, is(expected));
    }

}

