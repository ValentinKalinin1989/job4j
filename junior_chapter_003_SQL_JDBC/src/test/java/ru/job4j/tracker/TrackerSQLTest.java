package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TrackerSQLTest {
    @Test
    public void checkConnection() {
        TrackerSQL sql = new TrackerSQL();
        assertThat(sql.init(), is(true));
    }
    @Test
    public void testAddItem() {
        TrackerSQL sql = new TrackerSQL();
        sql.init();
        Item itemAdded = sql.add(new Item("ItemSQLTest", "Description", 120));
        Item itemFinded = sql.findById(itemAdded.getId());
        assertThat(itemAdded.getId(), is(itemFinded.getId()));
        assertThat(itemAdded.getName(), is(itemFinded.getName()));
        assertThat(sql.delete(itemAdded.getId()), is(true));
    }
    @Test
    public void testFindAllItem() {
        TrackerSQL sql = new TrackerSQL();
        sql.init();
        Item itemAdded0 = sql.add(new Item("ItemSQLTest0", "Description", 120));
        Item itemAdded1 = sql.add(new Item("ItemSQLTest1", "Description", 120));
        Item itemAdded2 = sql.add(new Item("ItemSQLTest2", "Description", 120));
        Item itemAdded3 = sql.add(new Item("ItemSQLTest3", "Description", 120));
        Item itemAdded4 = sql.add(new Item("ItemSQLTest4", "Description", 120));
        List<Item> items = sql.findAll();
        assertThat(items.get(0).getName(), is("ItemSQLTest0"));
        assertThat(items.get(1).getName(), is("ItemSQLTest1"));
        assertThat(items.get(2).getName(), is("ItemSQLTest2"));
        assertThat(items.get(3).getName(), is("ItemSQLTest3"));
        assertThat(items.get(4).getName(), is("ItemSQLTest4"));
        assertThat(sql.delete(itemAdded0.getId()), is(true));
        assertThat(sql.delete(itemAdded1.getId()), is(true));
        assertThat(sql.delete(itemAdded2.getId()), is(true));
        assertThat(sql.delete(itemAdded3.getId()), is(true));
        assertThat(sql.delete(itemAdded4.getId()), is(true));
    }
    @Test
    public void testFindByName() {
        TrackerSQL sql = new TrackerSQL();
        sql.init();
        Item itemAdded0 = sql.add(new Item("ItemSQLTest", "Description", 120));
        Item itemAdded1 = sql.add(new Item("ItemSQLTest", "Description", 120));
        Item itemAdded2 = sql.add(new Item("ItemSQLTest", "Description", 120));
        List<Item> items = sql.findByName("ItemSQLTest");
        assertThat(items.get(0).getName(), is("ItemSQLTest"));
        assertThat(items.get(1).getName(), is("ItemSQLTest"));
        assertThat(items.get(2).getName(), is("ItemSQLTest"));
        assertThat(sql.delete(itemAdded0.getId()), is(true));
        assertThat(sql.delete(itemAdded1.getId()), is(true));
        assertThat(sql.delete(itemAdded2.getId()), is(true));
    }
    @Test
    public void testReplaceItemAndDell() {
        TrackerSQL sql = new TrackerSQL();
        sql.init();
        Item itemAdded = sql.add(new Item("ItemSQLTest", "Description", 120));
        boolean result = sql.replace(itemAdded.getId(), new Item("ItemSQLUpdate", "Description", 120));
        assertThat(result, is(true));
        assertThat(sql.findById(itemAdded.getId()).getName(), is("ItemSQLUpdate"));
        assertThat(sql.delete(itemAdded.getId()), is(true));
    }
}