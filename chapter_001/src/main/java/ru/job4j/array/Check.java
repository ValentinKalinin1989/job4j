package ru.job4j.array;

/**
 * @author Valentin
 * @version 1.0
 * @since 12.01.2019
 */

public class Check {
    /**
     * Проверка значений массива на однородность
     * @param data массив
     * @return значение true или false в зависимости от однородности массива
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        boolean first = data[0];
        for (int i = 1; i < data.length; i++) {
            if (first != data[i]) {
                result = false;
            }
        }
        return result;
    }
}
