package ru.job4j.condition;

/**
 * @author Valentin
 * @version 1.00
 * @since 09.01.2019
 */
public class Point {
    private int x;
    private int y;

    /**
     * Конструктор
     *
     * @param x координата х
     * @param y координата у
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Расстояние между двумя точками
     *
     * @param that точка до котрой надо унать расстояние
     * @return расстояние между двумя точками
     */
    public double distanceTo(Point that) {
        return Math.sqrt(
                Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2)
        );
    }

}
