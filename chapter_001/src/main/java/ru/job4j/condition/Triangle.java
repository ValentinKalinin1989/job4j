package ru.job4j.condition;

/**
 * @author Valentin
 * @version 1.00
 * @since 09.01.2019
 */
public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    /**
     * Конструктор
     * @param a точка a
     * @param b точка b
     * @param c точка c
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Расчет полупериметра
     * @param ab расстояние от a до b
     * @param ac расстояние от a до c
     * @param bc расстояние от b до c
     * @return полупериметр
     */
    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }

    /**
     * Проверка вырожденности треугольника
     * @param ab расстояние от a до b
     * @param ac расстояние от a до c
     * @param bc расстояние от b до c
     * @return вырожденный треугольник - true, не вырожденный(можно построить) - false
     */
    private boolean exist(double ab, double ac, double bc) {
        return ((ab + ac == bc) || (ab + bc == ac) || (ac + bc == ab)) ? false : true;
    }

    /**
     * расчет площади треугольника
     * @return площадь треугольника, -1 если треугольник не возможно построить (вырожденный)
     */
    public double area() {
        double rsl = -1;
        double ab = this.a.distanceTo(this.b);
        double ac = this.a.distanceTo(this.c);
        double bc = this.b.distanceTo(this.c);
        double p = this.period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {

            rsl = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }
}
