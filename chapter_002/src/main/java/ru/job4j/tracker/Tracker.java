package ru.job4j.tracker;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Tracker {
    private final List<Item> items = new ArrayList<>(100);

    private int position = 0;

    private static final Random RN = new Random();

    public Item add(Item item) {
        item.setId(generateId());
        this.items.add(this.position, item);
        position++;
        return item;
    }

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    public boolean replace(String id, Item item) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                item.setId(id);
                items.set(i, item);
                return true;
            }
        }
        return false;

    }
    public boolean delete(String id) {
        for (int out = 0; out < items.size(); out++) {
            if (items.get(out) != null && items.get(out).getId().equals(id)) {
                items.remove(out);
                return true;
                }

            }
        return false;
    }

    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        result.addAll(0, this.items);
        return result;
    }

    public List<Item> findByName(String key) {
        //массив для сохранения найденных итемов
        List<Item> result = new ArrayList<>();

        for (Item item: items) {
           if (item != null && item.getName().equals(key)) {
               result.add(item);

           }
        }
        return result;
    }

    public Item findById(String id) {
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    public String getId(int i) {
        return this.items.get(i).getId();
    }

    public String getItemToString(int i) {
        return  this.items.get(i).toString();
    }
}
