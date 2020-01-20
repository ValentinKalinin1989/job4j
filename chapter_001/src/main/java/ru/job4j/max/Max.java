package ru.job4j.max;

/**
 * @author Kalinin
 * @version 1.00
 * @since 08.01.2019
 */
public class Max {

    /**
     * @param first  первое число
     * @param second второе число
     * @return максимальное значение
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * @param first  первое число
     * @param second второе число
     * @param third  третье число
     * @return максимальное значение
     */
    public int max(int first, int second, int third) {
        return max(max(first, second), third);
    }
}
