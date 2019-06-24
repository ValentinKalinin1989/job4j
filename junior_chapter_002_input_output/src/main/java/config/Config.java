package config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        List<String> list = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(list::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String string: list) {
            if (string.contains("=")) {
                String[] stringIn = string.split("=");
                values.put(stringIn[0], stringIn[1]);
            }
        }
    }

    public String value(String key) {
        if (!values.containsKey(key)) {
            throw new NoSuchElementException("Данный ключ отсутвует");
        }
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("app.properties"));
    }
}