package ru.job4j.exam;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SumArrayTest {
    @Test
    public void whenSumArray() {
        SumArray array = new SumArray();
        int[] firstArray = {1, 1, 3, 5, 7, 7};
        int[] secondArray = {1, 3, 3, 4, 6, 9, 9};
        int[] result = array.sumfunc(firstArray, secondArray);
        int[] arrayForCheck = {1, 1, 1, 3, 3, 3, 4, 5, 6, 7, 7, 9, 9};
        assertThat(result, is(arrayForCheck));
    }
}