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
    }
    @Test
    public void testFindItem() {
        TrackerSQL sql = new TrackerSQL();
        sql.init();
        Item itemFinded = sql.findById("624995469");
        assertThat("624995469", is(itemFinded.getId()));
    }
    @Test
    public void testFindAllItem() {
        TrackerSQL sql = new TrackerSQL();
        sql.init();
        List<Item> items = sql.findAll();
        assertThat(items.get(0).getName(), is("item1"));
        assertThat(items.get(1).getName(), is("item2"));
        assertThat(items.get(2).getName(), is("item1"));
        assertThat(items.get(3).getName(), is("item2"));
        assertThat(items.get(4).getName(), is("item1"));
        assertThat(items.get(5).getName(), is("item2"));
        assertThat(items.get(6).getName(), is("итемтест"));
    }
    @Test
    public void testFindByName() {
        TrackerSQL sql = new TrackerSQL();
        sql.init();
        List<Item> items = sql.findByName("item1");
        assertThat(items.get(0).getName(), is("item1"));
        assertThat(items.get(1).getName(), is("item1"));
        assertThat(items.get(2).getName(), is("item1"));
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