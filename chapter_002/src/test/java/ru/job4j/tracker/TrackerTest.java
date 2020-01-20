package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll().get(0), is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenFindAll() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("test", "TestDescrip1", 12L));
        tracker.add(new Item("test", "TestDescrip2", 123L));
        tracker.add(new Item("test12", "TestDescrip3", 1234L));
        tracker.add(new Item("test22", "TestDescrip4", 1235L));
        tracker.add(new Item("test", "TestDescrip15", 1222L));

        List<Item> itemstest = new ArrayList<>(3);
        itemstest.add(0, new Item("test", "TestDescrip1", 12L));
        itemstest.add(1, new Item("test", "TestDescrip2", 123L));
        itemstest.add(2, new Item("test", "TestDescrip15", 1222L));
        //отбираем все итемы с именем test
        //Item[] result = tracker.findByName("test");
        List<Item> result = tracker.findByName("test");

        assertThat(result.get(0).getName(), is("test"));
        assertThat(result.get(1).getName(), is("test"));
        assertThat(result.get(2).getName(), is("test"));

    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        tracker.add(next);
        tracker.delete(previous.getId());

        // Проверяем, что осталась одна заявка с именем "test2"
        assertThat(tracker.findAll().get(0).getName(), is("test2"));
    }


}
