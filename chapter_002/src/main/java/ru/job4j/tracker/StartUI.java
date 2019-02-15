package ru.job4j.tracker;

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
    private static Tracker tracker;
    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Основой цикл программы.
     */

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions(this);
        do {
            menu.show();
            String ask = input.ask("Введите пункт меню :");
            menu.select(Integer.valueOf(ask));
            } while (this.working);
    }

    public void stop() {
        this.working = false;
    }

}
