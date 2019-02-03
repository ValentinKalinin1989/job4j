package ru.job4j.tracker;

public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа меню для просмотра всех заявок.
     */
    private static final String SHOW = "1";
    /**
     * Константа меню для редактирования заявки.
     */
    private static final String EDIT = "2";
    /**
     * Константа меню для удаления заявки.
     */
    private static final String DEL = "3";
    /**
     * Константа меню для поиска заявки по id.
     */
    private static final String FINDBYID = "4";
    /**
     * Константа меню для поиска заявки по имени.
     */
    private static final String FINDBYNAME = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;
    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showItems();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DEL.equals(answer)) {
                this.delItem();
            } else if (FINDBYID.equals(answer)) {
                this.findById();
            } else if (FINDBYNAME.equals(answer)) {
                this.findByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }
    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    private void showItems() {
        Item[] items = this.tracker.findAll();
        System.out.println("------------Список всех заявок-------------------");
        for (Item item: items) {
            printItem(item);
        }
    }

    private void editItem() {
        String id = this.input.ask("Введите id заявки, которую необходимо редактировать:");
        String name = this.input.ask("Введите новое имя заявки :");
        String desc = this.input.ask("Введите новое описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.replace(id, item);
        System.out.println("Заявка отредактирована.");
    }

    private void delItem() {
        String id = this.input.ask("Введите id заявки, которую необходимо удалить:");
        this.tracker.delete(id);
        System.out.println("Заявка удалена.");
    }

    private void findById() {
        String id = this.input.ask("Введите id заявки, которую необходимо найти:");
        printItem(this.tracker.findById(id));
    }

    private void findByName() {
        String name = this.input.ask("Введите имя заявки, по которому нужно провести поиск:");
        Item[] items = this.tracker.findByName(name);
        for (Item item: items) {
            printItem(item);
        }
    }

    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0.Добавить заявку.");
        System.out.println("1.Показать все заявки.");
        System.out.println("2.Редактировать заявку.");
        System.out.println("3.Удалить заявку.");
        System.out.println("4.Найти заявку по id.");
        System.out.println("5.Найти заявку по имени");
    }

    private void printItem(Item item) {
        System.out.println("Имя заявки: " + item.getName() + "|" + " Описание: " + item.getDesc() + "|" +  " id: " + item.getId());
    }


    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
