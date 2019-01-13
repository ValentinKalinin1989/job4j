package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    @Test
    public void whenArraySort51273To12357() {
        BubbleSort array = new BubbleSort();
        int[] arrayToSort = {5, 1, 2, 7, 3};
        int[] result = array.sort(arrayToSort);
        int[] arraySort = {1, 2, 3, 5, 7};
        assertThat(result, is(arraySort));
    }
}
