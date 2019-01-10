package ru.job4j.loop;
/**
 * Package for point
 *@author Valentin
 *@version 1.00
 *@since 08/01/2019
 */
public class Counter {
    /**
     * Расчет суммы четных чисел от числа start до finish
     * @param start первое число
     * @param finish последее число
     * @return сумма четных чисел
     */
    public int add(int start, int finish) {
        int summa = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                summa += i;
            }
        }
        return summa;
    }
}
