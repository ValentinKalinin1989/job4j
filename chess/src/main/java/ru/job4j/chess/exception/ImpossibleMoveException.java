package ru.job4j.chess.exception;

public class ImpossibleMoveException extends RuntimeException {
    public ImpossibleMoveException(String message) {
        super(message);
    }
}
