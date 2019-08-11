package ru.job4j.tracker;

import java.util.function.Consumer;

public class StartUI {
    /**
     *маркер для выхода из программы в методе exit
     */
    private boolean working = true;
    /**
     * Получение данных от пользователя.
     */
    private static Input input;
    /**
     * Хранилище заявок.
     */
    private static ITracker tracker;
    /**
     * метод вводв данных
     * */
    private static Consumer<String> output;
    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     */
    public StartUI(Input input, ITracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }
    /**
     * Основой цикл программы.
     */

    public static void main(String[] args) {
        Input input = new ValidateInput(new ConsoleInput());
        ITracker tracker = new Tracker();
        new StartUI(input, tracker, System.out::println).init();
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, output);
        menu.fillActions(this);
        do {
            menu.show();
            //String ask = input.ask("Введите пункт меню :");
            //menu.select(Integer.valueOf(ask));
            menu.select(input.ask("Введите пункт меню", menu.getNumRangeActions()));
            } while (this.working);
    }

    public void stop() {
        this.working = false;
    }

}
