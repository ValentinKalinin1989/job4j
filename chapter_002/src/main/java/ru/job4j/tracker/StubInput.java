package ru.job4j.tracker;

public class StubInput implements Input {
    private final String[] value;
    private int position = 0;

    public StubInput(final String[] answers) {
        this.value = answers;
    }

    public String ask(String question) {
        return this.value[position++];
    }

    @Override
    public int ask(String question, int[] range) throws RuntimeException {
        int key = Integer.valueOf(this.ask(value[position]));
        boolean exists = false;
        for (int value : range) {
            if (value == key) {
                exists = true;
                break;
            }
        }
        if (!exists) {
            throw new MenuOutException("Выход за пределы значений меню.");
        }
        return key;
    }
}
