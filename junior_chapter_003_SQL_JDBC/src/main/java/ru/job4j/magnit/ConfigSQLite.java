package ru.job4j.magnit;

import java.io.InputStream;
import java.util.Properties;

public class ConfigSQLite {
    private final Properties values = new Properties();

    public void init() {
        try (InputStream in = ConfigSQLite.class.getClassLoader().getResourceAsStream("appSQLite.properties")) {
            values.load(in);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public String get(String key) {
        return this.values.getProperty(key);
    }
}
