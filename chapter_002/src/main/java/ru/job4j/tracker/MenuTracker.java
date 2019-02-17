package ru.job4j.tracker;

public class MenuTracker {

    private Input input;
    private Tracker tracker;

    private UserAction[] actions = new UserAction[7];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public int[] getNumRangeActions() {
        return new int[] {0, 1, 2, 3, 4, 5, 6};
    }
    /**
     * заполнение массива классами реализующими работу с трекером
     */
    public void fillActions(StartUI ui) {
        this.actions[0] = new AddItem();
        this.actions[1] = new ShowItems();
        this.actions[2] = new EditItem();
        this.actions[3] = new DelItem();
        this.actions[4] = new FindById();
        this.actions[5] = new FindByName();
        this.actions[6] = new Exit(ui);
    }

    /**
     * выполнение операции по управляющему номеру
     * @param key - номер операции
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * вывод меню
     */
    public void show() {
        System.out.println("Меню.");
        for (UserAction action: this.actions) {
            System.out.println(action.info());
        }
    }


    private static class AddItem implements UserAction {
        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
        }

        @Override
        public String info() {
            return String.format("%s.%s", this.key(), "Добавить заявку.");
        }
    }

    private static class ShowItems implements UserAction {
        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item[] items = tracker.findAll();
            System.out.println("------------Список всех заявок-------------------");
            for (Item item: items) {
                System.out.println(item.toString());
            }

        }

        @Override
        public String info() {
            return String.format("%s.%s", this.key(), "Показать все заявки.");
        }
    }

    private static class EditItem implements UserAction {
        @Override
        public int key() {
            return 2;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки, которую необходимо редактировать:");
            String name = input.ask("Введите новое имя заявки :");
            String desc = input.ask("Введите новое описание заявки :");
            Item item = new Item(name, desc);
            if (tracker.replace(id, item)) {
                System.out.println("Заявка отредактирована.");
            } else {
                System.out.println("Ошибка редактироования");
            }
        }

        @Override
        public String info() {
            return String.format("%s.%s", this.key(), "Редактировать заявку.");
        }
    }

    private static class DelItem implements UserAction {
        @Override
        public int key() {
            return 3;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки, которую необходимо удалить:");
            if (tracker.delete(id)) {
                System.out.println("Заявка удалена.");
            } else {
                System.out.println("Ошибка удаления.");
            }
        }

        @Override
        public String info() {
            return String.format("%s.%s", this.key(), "Удалить заявку.");
        }
    }

    private static class FindById implements UserAction {
        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки, которую необходимо найти:");
            System.out.println(tracker.findById(id).toString());
        }

        @Override
        public String info() {
            return String.format("%s.%s", this.key(), "Найти заявку по id.");
        }
    }

    private static class FindByName implements UserAction {
        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки, по которому нужно провести поиск:");
            Item[] items = tracker.findByName(name);
            for (Item item: items) {
                System.out.println(item.toString());
            }
        }

        @Override
        public String info() {
            return String.format("%s.%s", this.key(), "Найти заявку по имени");
        }
    }

    private static class Exit implements UserAction {
        private final StartUI ui;

        private Exit(StartUI ui) {
            this.ui = ui;
        }

        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            this.ui.stop();
        }

        @Override
        public String info() {
            return String.format("%s.%s", this.key(), "Выход из программы.");
        }
    }
}


