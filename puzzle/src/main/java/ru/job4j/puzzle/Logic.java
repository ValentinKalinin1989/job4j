package ru.job4j.puzzle;

import ru.job4j.puzzle.firuges.Cell;
import ru.job4j.puzzle.firuges.Figure;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final int size;
    private final Figure[] figures;
    private int index = 0;

    public Logic(int size) {
        this.size = size;
        this.figures = new Figure[size * size];
    }

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        int index = this.findBy(source);
        if (index != -1) {
            Cell[] steps = this.figures[index].way(source, dest);
            if (this.isFree(steps)) {
                rst = true;
                this.figures[index] = this.figures[index].copy(dest);
            }
        }
        return rst;
    }

    public boolean isFree(Cell ... cells) {
        boolean result = cells.length > 0;
        for (Cell cell : cells) {
            if (this.findBy(cell) != -1) {
               result = false;
               break;
            }
        }
        return result;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    public boolean isWin() {
        int[][] table = this.convert();
        boolean result = false;
        if ((table[0][0] + table[0][1] + table[0][2] + table[0][3] + table[0][4]) == 5) {
            result = true;
        }
        if ((table[1][0] + table[1][1] + table[1][2] + table[1][3] + table[1][4]) == 5) {
            result = true;
        }
        if ((table[2][0] + table[2][1] + table[2][2] + table[2][3] + table[2][4]) == 5) {
            result = true;
        }
        if ((table[3][0] + table[3][1] + table[3][2] + table[3][3] + table[3][4]) == 5) {
            result = true;
        }
        if ((table[4][0] + table[4][1] + table[4][2] + table[4][3] + table[4][4]) == 5) {
            result = true;
        }
        if ((table[0][0] + table[1][0] + table[2][0] + table[3][0] + table[4][0]) == 5) {
            result = true;
        }
        if ((table[0][1] + table[1][1] + table[2][1] + table[3][1] + table[4][1]) == 5) {
            result = true;
        }
        if ((table[0][2] + table[1][2] + table[2][2] + table[3][2] + table[4][2]) == 5) {
            result = true;
        }
        if ((table[0][3] + table[1][3] + table[2][3] + table[3][3] + table[4][3]) == 5) {
            result = true;
        }
        if ((table[0][4] + table[1][4] + table[2][4] + table[3][4] + table[4][4]) == 5) {
            result = true;
        }

        return result;
    }

    public int[][] convert() {
        int[][] table = new int[this.size][this.size];
        for (int row = 0; row != table.length; row++) {
            for (int cell = 0; cell != table.length; cell++) {
                int position = this.findBy(new Cell(row, cell));
                if (position != -1 && this.figures[position].movable()) {
                    table[row][cell] = 1;
                }
            }
        }
        return table;
    }
}
