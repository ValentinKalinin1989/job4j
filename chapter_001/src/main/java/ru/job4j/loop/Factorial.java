package ru.job4j.loop;
/**
 * Package for point
 *@author Valentin
 *@version 1.00
 *@since 08/01/2019
 */
public class Factorial {
    /**
     * Расчет факториала
     * @param n положительное число
     * @return факториал
     */
    public int calc(int n) {
        int fact = 1;
        if (n != 0) {
            for (int i = 1; i <= n; i++) {
             fact *= i;
            }
        }
        return fact;
    }
}
