package ru.job4j.tracker;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TrackerSQLTest {

    public Connection init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
    @Test
    public void createItem() throws SQLException {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name", "desc", 120));
            assertThat(tracker.findByName("name").get(0).getName(), is("name"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testAddItem() {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            Item itemAdded = tracker.add(new Item("ItemSQLTest", "Description", 120));
            Item itemFinded = tracker.findById(itemAdded.getId());
            assertThat(itemAdded.getId(), is(itemFinded.getId()));
            assertThat(itemAdded.getName(), is(itemFinded.getName()));
            assertThat(tracker.delete(itemAdded.getId()), is(true));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testFindAllItem() {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            tracker.init();
            Item itemAdded0 = tracker.add(new Item("ItemSQLTest0", "Description", 120));
            Item itemAdded1 = tracker.add(new Item("ItemSQLTest1", "Description", 120));
            Item itemAdded2 = tracker.add(new Item("ItemSQLTest2", "Description", 120));
            Item itemAdded3 = tracker.add(new Item("ItemSQLTest3", "Description", 120));
            Item itemAdded4 = tracker.add(new Item("ItemSQLTest4", "Description", 120));
            List<Item> items = tracker.findAll();
            assertThat(items.get(0).getName(), is("ItemSQLTest0"));
            assertThat(items.get(1).getName(), is("ItemSQLTest1"));
            assertThat(items.get(2).getName(), is("ItemSQLTest2"));
            assertThat(items.get(3).getName(), is("ItemSQLTest3"));
            assertThat(items.get(4).getName(), is("ItemSQLTest4"));
            assertThat(tracker.delete(itemAdded0.getId()), is(true));
            assertThat(tracker.delete(itemAdded1.getId()), is(true));
            assertThat(tracker.delete(itemAdded2.getId()), is(true));
            assertThat(tracker.delete(itemAdded3.getId()), is(true));
            assertThat(tracker.delete(itemAdded4.getId()), is(true));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testFindByName() {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            tracker.init();
            Item itemAdded0 = tracker.add(new Item("ItemSQLTest", "Description", 120));
            Item itemAdded1 = tracker.add(new Item("ItemSQLTest", "Description", 120));
            Item itemAdded2 = tracker.add(new Item("ItemSQLTest", "Description", 120));
            List<Item> items = tracker.findByName("ItemSQLTest");
            assertThat(items.get(0).getName(), is("ItemSQLTest"));
            assertThat(items.get(1).getName(), is("ItemSQLTest"));
            assertThat(items.get(2).getName(), is("ItemSQLTest"));
            assertThat(tracker.delete(itemAdded0.getId()), is(true));
            assertThat(tracker.delete(itemAdded1.getId()), is(true));
            assertThat(tracker.delete(itemAdded2.getId()), is(true));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testReplaceItemAndDell() {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            tracker.init();
            Item itemAdded = tracker.add(new Item("ItemSQLTest", "Description", 120));
            boolean result = tracker.replace(itemAdded.getId(), new Item("ItemSQLUpdate", "Description", 120));
            assertThat(result, is(true));
            assertThat(tracker.findById(itemAdded.getId()).getName(), is("ItemSQLUpdate"));
            assertThat(tracker.delete(itemAdded.getId()), is(true));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}