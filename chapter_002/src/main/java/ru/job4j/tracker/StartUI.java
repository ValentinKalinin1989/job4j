package ru.job4j.tracker;

public class StartUI {
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
        menu.fillActions();
        do {
            menu.show();
            String ask = input.ask("Введите пункт меню :");
            if (ask.equals("6")) {
                break;
            }
            if (0 <= Integer.valueOf(ask) && Integer.valueOf(ask) <= 5) {
                menu.select(Integer.valueOf(ask));
            }
        } while (true);
    }

}
