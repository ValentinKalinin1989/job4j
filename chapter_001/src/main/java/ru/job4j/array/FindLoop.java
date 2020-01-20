package ru.job4j.array;

/**
 * @author Valentin
 * @version 1.0
 * @since 12.01.2019
 */
public class FindLoop {
    /**
     * Поиск значения в массиве
     *
     * @param data массив
     * @param el   значение для поиска
     * @return номер элемента массива, которое содержит заданное значение; если значение не найдено: -1
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}