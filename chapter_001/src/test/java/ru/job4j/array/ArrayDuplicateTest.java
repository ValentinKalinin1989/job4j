package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate array = new ArrayDuplicate();
        String[] arrayToDelDubl = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] result = array.remove(arrayToDelDubl);
        String[] arrayToTest = {"Привет", "Мир", "Супер"};
        assertThat(result, is(arrayToTest));
    }
}
