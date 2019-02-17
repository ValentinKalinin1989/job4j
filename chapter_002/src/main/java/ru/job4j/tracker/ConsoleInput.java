package ru.job4j.tracker;

import java.util.*;

public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
    @Override
    public int ask(String question, int[] range) throws MenuOutException {
        int key = Integer.valueOf(this.ask(question));
        boolean exists = false;
        for (int value: range) {
            if (value == key) {
                exists = true;
                break;
            }
        }
        if (exists) {
            return key;
        } else {
            throw new MenuOutException("Выход за пределы значений меню.");
        }
    }
}
