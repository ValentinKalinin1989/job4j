package ru.job4j.loop;

public class Board {
    /**
     * Построение шахматного поля из символов " " и "X"
     * @param width ширина
     * @param height высота
     * @return шахматное поле
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}
