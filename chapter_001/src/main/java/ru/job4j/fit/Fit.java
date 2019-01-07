package ru.job4j.fit;

public class Fit {

    /**
     * идеальный вес мужчины
     * @param height рост в см
     * @return вес в кг
     */
    public double manWeight(double height) {
        return (height - 100) * 1.15;
    }

    /**
     * идеальный вес женщины
     * @param height рост в см
     * @return вес в кг
     */
    public double womanWeight(double height) {
        return (height - 110) * 1.15;
    }
}
