package ru.job4j.tracker;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.InputStream;
import java.sql.*;
import java.util.*;

import static java.lang.Integer.parseInt;

public class TrackerSQL implements ITracker, AutoCloseable {

    private static final Random RN = new Random();
    private static final Logger LOG = LogManager.getLogger(UsageLog4j2.class.getName());
    private final Connection connection;

    public TrackerSQL(Connection connection) {
        this.connection = connection;
    }

    public boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            //this.connection = DriverManager.getConnection(
             //       config.getProperty("url"),
             //       config.getProperty("username"),
             //       config.getProperty("password")
            //);
            PreparedStatement stCr = this.connection.prepareStatement(
                    "create table if not exists item(id serial primary key, name_item varchar(50), description varchar(100), time_create int) ");
            stCr.executeUpdate();
            stCr.close();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return this.connection != null;
    }
    @Override
    public void close() throws Exception {
        if (this.connection != null) {
                  try {
                     this.connection.close();
                  } catch (SQLException e) {
                     LOG.error(e.getMessage(), e);
                  }
        }
    }
    @Override
    public Item add(Item item) {
        try (PreparedStatement st = this.connection.prepareStatement("insert into item(name_item, description, time_create) values (?, ?, ?) returning id")) {
            st.setString(1, item.getName());
            st.setString(2, item.getDesc());
            st.setLong(3, item.getCreated());
            ResultSet rs = st.executeQuery();
            rs.next();
            item.setId(String.valueOf(rs.getInt("id")));
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return item;
    }
    @Override
    public boolean replace(String id, Item item) {
        boolean result = false;
        try (PreparedStatement st = this.connection.prepareStatement("update item set name_item = ?, description = ?, time_create = ? where id = ?")) {
            st.setString(1, item.getName());
            st.setString(2, item.getDesc());
            st.setLong(3, item.getCreated());
            st.setInt(4, parseInt(id));
            st.executeUpdate();
            st.close();
            result = true;
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }
    @Override
    public boolean delete(String id) {
        boolean result = false;
        try (PreparedStatement st = this.connection.prepareStatement("delete from item where id = ?");) {
            st.setInt(1, parseInt(id));
            st.executeUpdate();
            st.close();
            result = true;
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }
    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        try (Statement st = this.connection.createStatement()) {
            ResultSet rs = st.executeQuery("select * from item");
            writeItemInList(rs, items);
            st.close();
            rs.close();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return items;
    }
    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement st = this.connection.prepareStatement("select * from item where name_item = ?");) {
            st.setString(1, key);
            ResultSet rs = st.executeQuery();
            writeItemInList(rs, items);
            st.close();
            rs.close();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return items;
    }
    @Override
    public Item findById(String id) {
        Item resultItem = null;
        try (PreparedStatement st = this.connection.prepareStatement("select * from item where id = ?")) {
            st.setInt(1, parseInt(id));
            ResultSet rs = st.executeQuery();
            rs.next();
            resultItem = new Item(rs.getString("name_item"), rs.getString("description"), rs.getLong("time_create"));
            resultItem.setId(rs.getString("id"));
            st.close();
            rs.close();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return resultItem;
    }
    /**
     * add Item in List
     * @param rs ResultSet
     * @param items list of Item for add finded Items
     * @throws SQLException
     */
    private void writeItemInList(ResultSet rs, List<Item> items) throws SQLException {
        while (rs.next()) {
            Item item = new Item(rs.getString("name_item"), rs.getString("description"), rs.getLong("time_create"));
            item.setId(String.valueOf(rs.getInt("id")));
            items.add(item);
        }
    }
}
