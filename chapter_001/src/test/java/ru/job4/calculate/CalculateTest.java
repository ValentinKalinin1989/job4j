package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author Valentin Kalinin (k-valentin-1989@yandex.ru)
* @version $Id$
* @since 03.01.2019
*/
public class CalculateTest {
/**
* Test echo.
*/
@Test
public void whenTakeNameThenThreeEchoPlusName() {
    String input = "Valentin Kalinin";
    String expect = "Echo, echo, echo : Valentin Kalinin"; 
    Calculate calc = new Calculate();
    String result = calc.echo(input);
    assertThat(result, is(expect));
}
 
}