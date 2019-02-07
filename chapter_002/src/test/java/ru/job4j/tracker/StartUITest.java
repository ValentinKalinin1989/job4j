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
                        .append("Меню.\\r\\n")
                        .append("0.Добавить заявку.\\r\\n")
                        .append("1.Показать все заявки.\\r\\n")
                        .append("2.Редактировать заявку.\\r\\n")
                        .append("3.Удалить заявку.\\r\\n")
                        .append("4.Найти заявку по id.\\r\\n")
                        .append("5.Найти заявку по имени\\r\\n")
                        .append("6.Выход из программы.\\r\\n")
                        .append("------------ Добавление новой заявки --------------\\r\\n")
                        .append("------------ Новая заявка с getId : " + id + "-----------\\r\\n")
                        .append("Меню.\\r\\n")
                        .append("0.Добавить заявку.\\r\\n")
                        .append("1.Показать все заявки.\\r\\n")
                        .append("2.Редактировать заявку.\\r\\n")
                        .append("3.Удалить заявку.\\r\\n")
                        .append("4.Найти заявку по id.\\r\\n")
                        .append("5.Найти заявку по имени\\r\\n")
                        .append("6.Выход из программы.\\r\\n")
                        .toString()
                )
        );
    }
}
