package ru.job4j.tracker;

public class ValidateInput extends  ConsoleInput {
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException nfe) {
                System.out.println("Введите ключ из меню.");
            } catch (NumberFormatException nfe) {
                System.out.println("Введите корректные данные повторно.");
            }
        } while (invalid);
            return value;
    }
}

