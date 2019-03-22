package ru.job4j.chess.firuges.black;

import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
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
        Cell[] steps = new Cell[0];
        boolean checkValid = false;
        int deltaX = Integer.compare(dest.x, source.x);
        int deltaY = Integer.compare(dest.y, source.y);
        int move = Math.abs(source.x - source.y);
        if (source.y == dest.y + move && source.x == dest.x + move
                || source.y == dest.y + move && source.x == dest.x - move
                || source.y == dest.y - move && source.x == dest.x + move
                || source.y == dest.y - move && source.x == dest.x - move) {
            steps = new Cell[move];
            steps[0] = Cell.findCell(source.x + deltaX, source.y + deltaY);
            for (int index = 1; index < steps.length; index++) {
                steps[index] = Cell.findCell(steps[index - 1].x + deltaX, steps[index - 1].y + deltaY);
            }
            checkValid = true;
            if (!checkValid) {
                throw new ImpossibleMoveException("Движение по данному пути не возможно");
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
