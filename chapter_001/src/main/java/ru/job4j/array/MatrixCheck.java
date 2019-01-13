package ru.job4j.array;

/**
 * @author Valentin
 * @version 1.0
 * @since 13.01.2019
 */

public class MatrixCheck {
    /**
     * Проверка диагоналей массива на однородность
     * @param data массив
     * @return true или false
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        boolean element = data[0][0];
        for (int i = 0; i < data.length; i++) {
            if (element != data[i][i]) {
                result = false;
                break;
            }
            if (element != data[i][data.length - 1 - i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
