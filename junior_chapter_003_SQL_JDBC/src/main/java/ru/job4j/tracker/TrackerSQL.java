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
    private Connection connection;

    public boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
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
        try {
            item.setId(String.valueOf(RN.nextInt(Integer.MAX_VALUE)));
            PreparedStatement stCr = this.connection.prepareStatement("create table if not exists item(id serial primary key, description varchar(2000), comment_id int references comments(id)");
            stCr.close();
            PreparedStatement st = this.connection.prepareStatement("insert into item(id, description, comment_id) values (?, ?, ?)");
            st.setInt(1, parseInt(item.getId()));
            st.setString(2, item.getName());
            st.setInt(3, 1);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return item;
    }
    @Override
    public boolean replace(String id, Item item) {
        boolean result = false;
        try {
            PreparedStatement st = this.connection.prepareStatement("update item set description = ? where id = ?");
            st.setString(1, item.getName());
            st.setInt(2, parseInt(id));
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
        try {
            PreparedStatement st = this.connection.prepareStatement("delete from item where id = ?");
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
        try {
            Statement st = this.connection.createStatement();
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
        try {
            PreparedStatement st = this.connection.prepareStatement("select * from item where description = ?");
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
        try {
            PreparedStatement st = this.connection.prepareStatement("select * from item where id = ?");
            st.setInt(1, parseInt(id));
            ResultSet rs = st.executeQuery();
            rs.next();
            resultItem = new Item(rs.getString("description"), "коммент", 1);
            resultItem.setId(rs.getString("id"));
            st.close();
            rs.close();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return resultItem;
    }

    private void writeItemInList(ResultSet rs, List<Item> items) throws SQLException {
        while (rs.next()) {
            Item item = new Item(rs.getString("description"), "коммент", 1);
            item.setId(String.valueOf(rs.getInt("id")));
            items.add(item);
        }
    }
}
