package ru.job4j.converter;

/**
 * Корвертор валюты.
 */
public class Converter {

    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return value / 70;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллары
     */
    public int rubleToDollar(int value) {
        return value / 60;
    }

    /**
     * Конвертируем евро в рубли
     * @param value евро
     * @return рубли
     */
    public int euroToRubble(int value) {
        return value * 70;
    }

    /**
     * Конвертируем доллар в рубли
     * @param value доллар
     * @return рубли
     */
    public int dollarToRubble(int value) {
        return value * 60;
    }
}