package ru.job4j.coffeemachine;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CoffeeMachineTest {
    @Test
    public void when15to10and5() {
        CoffeeMachine machine = new CoffeeMachine();
        int[]expect = {10, 5};
        int[] result = machine.changes(50, 35);
        assertThat(result, is(expect));
    }
    @Test
    public void when30to3for10() {
        CoffeeMachine machine = new CoffeeMachine();
        int[] expect = {10, 10, 10};
        int[] result = machine.changes(50, 20);
        assertThat(result, is(expect));
    }
    @Test
    public void whentestallnumber() {
        CoffeeMachine machine = new CoffeeMachine();
        int[] expect = {10, 5, 2, 1};
        int[] result = machine.changes(50, 32);
        assertThat(result, is(expect));
    }

}
