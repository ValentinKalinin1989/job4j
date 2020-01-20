package ru.job4j.tracker;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MenuTracker {

    private static Input input;
    private static ITracker tracker;
    private static Consumer<String> output;

    //private UserAction[] actions = new UserAction[7];

    private List<UserAction> actions = new ArrayList<>(7);

    public MenuTracker(Input input, ITracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    public int[] getNumRangeActions() {
        return new int[]{0, 1, 2, 3, 4, 5, 6};
    }

    /**
     * заполнение массива классами реализующими работу с трекером
     */
    public void fillActions(StartUI ui) {
        this.actions.add(0, new AddItem(0, "Добавить заявку."));
        this.actions.add(1, new ShowItems(1, "Показать все заявки."));
        this.actions.add(2, new EditItem(2, "Редактировать заявку."));
        this.actions.add(3, new DelItem(3, "Удалить заявку."));
        this.actions.add(4, new FindById(4, "Найти заявку по id."));
        this.actions.add(5, new FindByName(5, "Найти заявку по имени"));
        this.actions.add(6, new Exit(ui));
    }

    /**
     * выполнение операции по управляющему номеру
     *
     * @param key - номер операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * вывод меню
     */
    public void show() {
        output.accept("Меню.");
        for (UserAction action : this.actions) {
            output.accept(action.info());
        }
    }


    private static class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }


        public void execute(Input input, ITracker tracker) {
            output.accept("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            output.accept("------------ Новая заявка с getId : " + item.getId() + "-----------");
        }

    }

    private static class ShowItems extends BaseAction {

        public ShowItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, ITracker tracker) {
            List<Item> items = tracker.findAll();
            output.accept("------------Список всех заявок-------------------");
            for (Item item : items) {
                output.accept(item.toString());
            }

        }

    }

    private static class EditItem extends BaseAction {

        public EditItem(int key, String name) {

            super(key, name);
        }

        @Override
        public void execute(Input input, ITracker tracker) {
            String id = input.ask("Введите id заявки, которую необходимо редактировать:");
            String name = input.ask("Введите новое имя заявки :");
            String desc = input.ask("Введите новое описание заявки :");
            Item item = new Item(name, desc);
            if (tracker.replace(id, item)) {
                output.accept("Заявка отредактирована.");
            } else {
                output.accept("Ошибка редактироования");
            }
        }

    }

    private static class DelItem extends BaseAction {

        public DelItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, ITracker tracker) {
            String id = input.ask("Введите id заявки, которую необходимо удалить:");
            if (tracker.delete(id)) {
                output.accept("Заявка удалена.");
            } else {
                output.accept("Ошибка удаления.");
            }
        }


    }

    private static class FindById extends BaseAction {

        public FindById(int key, String name) {
            super(key, name);
        }


        public void execute(Input input, ITracker tracker) {
            String id = input.ask("Введите id заявки, которую необходимо найти:");
            output.accept(tracker.findById(id).toString());
        }

    }

    private static class FindByName extends BaseAction {

        public FindByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, ITracker tracker) {
            String name = input.ask("Введите имя заявки, по которому нужно провести поиск:");
            List<Item> items = tracker.findAll();
            for (Item item : items) {
                if (item != null && item.getName().equals(name)) {
                    output.accept(item.toString());
                }
            }
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
        public void execute(Input input, ITracker tracker) {
            this.ui.stop();
        }

        @Override
        public String info() {
            return String.format("%s.%s", this.key(), "Выход из программы.");
        }
    }
}


