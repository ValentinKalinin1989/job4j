package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        tracker.add(next);

        Input input = new StubInput(new String[]{"3", previous.getId(), "6"});
        tracker.delete(previous.getId());

        // Проверяем, что осталась одна заявка с именем "test2"
        assertThat(tracker.findAll()[0].getName(), is("test2"));
    }


    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    private static final String LS = System.lineSeparator();
    private static final String MENU = new StringBuilder()
            .append("Меню.").append(LS)
            .append("0.Добавить заявку.").append(LS)
            .append("1.Показать все заявки.").append(LS)
            .append("2.Редактировать заявку.").append(LS)
            .append("3.Удалить заявку.").append(LS)
            .append("4.Найти заявку по id.").append(LS)
            .append("5.Найти заявку по имени").append(LS)
            .append("6.Выход из программы.").append(LS).toString();


    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenTestShowItem() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        String id = tracker.getId(0);
        assertThat(this.out.toString(), is(
                new StringBuilder()
                        .append(MENU)
                        .append("------------ Добавление новой заявки --------------").append(LS)
                        .append("------------ Новая заявка с getId : ").append(id).append("-----------").append(LS)
                        .append(MENU)
                        .toString()
                )
        );
    }


    @Test
    public void whenTestFindAll() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name 1", "desc 1", "0", "test name 2", "desc 2", "1", "6"});
        new StartUI(input, tracker).init();
        String id1 = tracker.getId(0);
        String id2 = tracker.getId(1);
        assertThat(this.out.toString(), is(
                new StringBuilder()
                        .append(MENU)
                        .append("------------ Добавление новой заявки --------------").append(LS)
                        .append("------------ Новая заявка с getId : ").append(id1).append("-----------").append(LS)
                        .append(MENU)
                        .append("------------ Добавление новой заявки --------------").append(LS)
                        .append("------------ Новая заявка с getId : ").append(id2).append("-----------").append(LS)
                        .append(MENU)
                        .append("------------Список всех заявок-------------------").append(LS)
                        .append(tracker.getItemToString(0)).append(LS)
                        .append(tracker.getItemToString(1)).append(LS)
                        .append(MENU).toString()
                )
        );
    }

    @Test
    public void whenTestFindByName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name 1", "desc 1",
                "0", "test name 2", "desc 2",
                "0", "test name 1", "desc 3",
                "0", "test name 3", "desc 4",
                "5", "test name 1", "6"});
        new StartUI(input, tracker).init();
        String id0 = tracker.getId(0);
        String id1 = tracker.getId(1);
        String id2 = tracker.getId(2);
        String id3 = tracker.getId(3);
        assertThat(this.out.toString(), is(
                new StringBuilder()
                        .append(MENU)
                        .append("------------ Добавление новой заявки --------------").append(LS)
                        .append("------------ Новая заявка с getId : ").append(id0).append("-----------").append(LS)
                        .append(MENU)
                        .append("------------ Добавление новой заявки --------------").append(LS)
                        .append("------------ Новая заявка с getId : ").append(id1).append("-----------").append(LS)
                        .append(MENU)
                        .append("------------ Добавление новой заявки --------------").append(LS)
                        .append("------------ Новая заявка с getId : ").append(id2).append("-----------").append(LS)
                        .append(MENU)
                        .append("------------ Добавление новой заявки --------------").append(LS)
                        .append("------------ Новая заявка с getId : ").append(id3).append("-----------").append(LS)
                        .append(MENU)
                        .append(tracker.getItemToString(0)).append(LS)
                        .append(tracker.getItemToString(2)).append(LS)
                        .append(MENU).toString()
                )
        );
    }

}
