package ru.job4j.array;

/**
 * @author Valentin
 * @version 1.0
 * @since 12.01.2019
 */

public class Turn {
    /**
     * Перемена местами значений в массиве
     * @param array массив
     * @return массив с перемещенными значениями
     */
    public int[] back(int[] array) {
        for (int i = 0; i < (array.length/2); i++ ) {
            int a = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = a;
        }
        return array;
    }
}
