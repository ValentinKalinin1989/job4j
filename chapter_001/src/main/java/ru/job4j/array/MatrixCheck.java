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
        boolean element1 = data[0][0];
        boolean element2 = data[0][data.length - 1];
        for (int i = 0; i < data.length; i++) {
            if (element1 != data[i][i]) {
                result = false;
                break;
            }
            if (element2 != data[i][data.length - 1 - i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
