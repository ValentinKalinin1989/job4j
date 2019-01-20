package ru.job4j.loop;
import java.util.function.BiPredicate;

public class Paint {
    /**
     * Построение треугольника в право
     * @param height высота
     * @return треугольник в право
     */
    public String rightTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );
    }
    /**
     * Построение треугольника в лево
     * @param height высота
     * @return треугольник в лево
     */
    public String leftTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
    }
    /**
     * Построение пирамиды
     * @param height высота
     * @return пирамида
     */
    public String pyramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }
    /**
     * Построение фигуры по заданным параметрам
     * @param height высота
     * @param weight ширина
     * @param predict парматры для фигуры
     * @return выбранная фигуры
     */
    private String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}