package ru.job4j.array;

/**
 * @author Valentin
 * @version 1.0
 * @since 12.01.2019
 */
public class Square {
    /**
     * Заполнение массива квадратами чисел
     * @param bound размер массива
     * @return массив из квадратов
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i < rst.length; i++) {
            rst[i] = (int) Math.pow((i + 1), 2);
        }
        return rst;
    }
}
