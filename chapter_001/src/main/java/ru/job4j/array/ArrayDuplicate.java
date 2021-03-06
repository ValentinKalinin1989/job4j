package ru.job4j.array;
/*
 * @author Valentin
 * @version 1.0
 * @since 13.01.2019
 */

import java.util.Arrays;

public class ArrayDuplicate {
    /**
     * Удаление дубликатов в массиве
     *
     * @param array массив
     * @return массив без дубликатов
     */
    public String[] remove(String[] array) {
        int unique = array.length;
        for (int out = 0; out < unique; out++) {
            String a = array[out];
            for (int in = out + 1; in < (unique - 1); in++) {
                if (array[out].equals(array[in])) {
                    array[in] = null;
                    array[in] = array[unique - 1];
                    unique--;
                    in--;
                }
            }
        }
        return Arrays.copyOf(array, (unique));
    }

}
