package ru.job4j.chess.firuges.black;

import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {

        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if (!isDiagonal(source, dest)) {
            return new Cell[]{source};
            // throw new ImpossibleMoveException ("Движение по данному пути не возможно");
        }
        int deltaX = Integer.compare(dest.x, source.x);
        int deltaY = Integer.compare(dest.y, source.y);
        int move = Math.abs(source.y - dest.y);
        Cell[] steps;
        steps = new Cell[move];
        steps[0] = Cell.findCell(source.x + deltaX, source.y + deltaY);
        for (int index = 1; index < steps.length; index++) {
            steps[index] = Cell.findCell(steps[index - 1].x + deltaX, steps[index - 1].y + deltaY);
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

    private boolean isDiagonal(Cell source, Cell dest) {
        boolean flag = false;
        double x = Math.pow((dest.x - source.x), 2);
        double y = Math.pow((dest.y - source.y), 2);
        if (x == y && dest.y <= 8 && dest.y > 0 && dest.x <= 8 && dest.x > 0) {
            flag = true;
        }
        return flag;
    }
}