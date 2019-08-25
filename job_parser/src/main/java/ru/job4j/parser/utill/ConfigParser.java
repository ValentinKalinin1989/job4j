package ru.job4j.parser.utill;

import java.io.InputStream;
import java.util.Properties;

public class ConfigParser {
    private final Properties values = new Properties();
    public void init() {
        try (InputStream in = ConfigParser.class.getClassLoader().getResourceAsStream("app.properties")) {
            values.load(in);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
    public String get(String key) {
        return this.values.getProperty(key);
    }
}