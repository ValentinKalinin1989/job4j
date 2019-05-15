package ru.job4j.tictactoe;

import java.util.function.Predicate;

public class Logic {
    private final Figure[][] table;

    public Logic(Figure[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isWinnerX() {
        return this.fillBy(Figure::hasMarkX, 0, 0, 1, 0)
                || this.fillBy(Figure::hasMarkX, 0, 1, 1, 0)
                || this.fillBy(Figure::hasMarkX, 0, 2, 1, 0)
                || this.fillBy(Figure::hasMarkX, 0, 0, 0, 1)
                || this.fillBy(Figure::hasMarkX, 1, 0, 0, 1)
                || this.fillBy(Figure::hasMarkX, 2, 0, 0, 1)
                || this.fillBy(Figure::hasMarkX, 0, 0, 1, 1)
                || this.fillBy(Figure::hasMarkX, this.table.length - 1, 0, -1, 1);
    }

    public boolean isWinnerO() {
        return this.fillBy(Figure::hasMarkO, 0, 0, 1, 0)
                || this.fillBy(Figure::hasMarkO, 0, 1, 1, 0)
                || this.fillBy(Figure::hasMarkO, 0, 2, 1, 0)
                || this.fillBy(Figure::hasMarkO, 0, 0, 0, 1)
                || this.fillBy(Figure::hasMarkO, 1, 0, 0, 1)
                || this.fillBy(Figure::hasMarkO, 2, 0, 0, 1)
                || this.fillBy(Figure::hasMarkO, 0, 0, 1, 1)
                || this.fillBy(Figure::hasMarkO, this.table.length - 1, 0, -1, 1);
    }

    public boolean hasGap() {
        boolean result = false;
        for (int out = 0; out != this.table.length; out++) {
            for (int in = 0; in != this.table.length; in++) {
                Figure cell = this.table[out][in];
                if (!cell.hasMarkX() && !cell.hasMarkO()) {
                    result = true;
                }
            }
        }
        return result;
    }
}
