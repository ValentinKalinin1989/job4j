package ru.job4.magnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.tracker.UsageLog4j2;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StoreSQLite implements AutoCloseable {
    private static final Logger LOG = LogManager.getLogger(UsageLog4j2.class.getName());
    private final ConfigSQLite config;
    private Connection connect;
    private int size;
    /***
     * constuctor
     * @param config
     */
    public StoreSQLite(ConfigSQLite config) {
        this.config = config;
    }

    public void generate(int size) {
        this.size = size;
        try {
            this.connect = DriverManager.getConnection(config.get("url"));
            PreparedStatement st = this.connect.prepareStatement("create table if not exists entry(field integer)");
            st.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        try {
            PreparedStatement st = this.connect.prepareStatement("insert into entry(field) values (?)");
            for (int i = 1; i <= size; i++) {
                st.setInt(1, i);
                st.addBatch();
            }
            st.executeBatch();
            st.close();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    public List<Entry> load() {
        List<Entry> list = new ArrayList<Entry>(size);
        try (Statement st = this.connect.createStatement()) {
            ResultSet rs =  st.executeQuery("select *from entry");
            while (rs.next()) {
                list.add(new Entry(rs.getInt("field")));
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return list;
    }

    @Override
    public void close() throws Exception {
        if (connect != null) {
            connect.close();
        }
    }

    public class Entry {
        private int value;
        public Entry(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
        public void setValue(int value) {
            this.value = value;
        }
    }
}
