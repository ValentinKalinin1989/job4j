package ru.job4j.array;

/**
 * @author Valentin
 * @version 1.0
 * @since 13.01.2019
 */

public class BubbleSort {
    /**
     * Алгоритм пузырьковой сортировки от меньшего к большему
     * @param array массив для сортировки
     * @return отсортированный массив
     */
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < (array.length - 1 - i); j++) {
                if (array[j] > array[j + 1]) {
                    int a = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = a;
                }
            }
        }
        return array;
    }
}
