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
     * @param array массив
     * @return массив без дубликатов
     */
    public String[] remove(String[] array) {
        int dubl = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < (array.length - 1); j++) {
                if (array[i].equals(array[j])) { // если найден дубликат, то сдвинуть значения влево
                    for (int k = j; k < (array.length - 1); k++) {
                        array[k] = array[k + 1];
                    }
                    dubl++; // увеличить счетчик дубликатов на единицу
                }
            }
        }
        return Arrays.copyOf(array, (array.length - dubl));
    }
}
