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
    public int ask(String question, int[] range) {
        //throw new UnsupportedOperationException("Unsopported operation");
        return -1;
    }
}
