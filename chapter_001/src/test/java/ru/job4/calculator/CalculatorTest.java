package ru.job4.calculator;

import org.junit.Test;
import ru.job4j.calculator.Calculator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author Valentin Kalinin (k-valentin-1989@yandex.ru)
* @version $Id$
* @since 03.01.2019
*/
public class CalculatorTest {

    /**
     * @Test тест сложения
     */
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * @Test тест вычитания
     */

    public void whenSubtractOneMinusOneThenZero() {
        Calculator calc = new Calculator();
        calc.subtract(1D, 1D);
        double result = calc.getResult();
        double expected = 0;
        assertThat(result, is(expected));
    }

    /**
     * @Test тест деления
     */

    public void whenDivOneDivOneThenOne() {
        Calculator calc = new Calculator();
        calc.div(1D, 1D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }

    /**
     * @Test тест умножения
     */

    public void whenMultipleOneAndOneThenOne() {
        Calculator calc = new Calculator();
        calc.multiple(1D, 1D);
        double result = calc.getResult();
        double expexted = 1D;
        assertThat(result, is(expexted));
    }

 
}