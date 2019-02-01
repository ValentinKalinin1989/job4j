package ru.job4j.tracker;

import java.util.*;

public class Tracker {
    private final Item[] items = new Item[100];

    private int position = 0;

    private static final Random RN = new Random();

    public Item add(Item item) {
        item.setId(generateId());
        this.items[this.position++] = item;
        return item;
    }

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    public boolean replace(String id, Item item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].getId().equals(id)) {
                item.setId(id);
                items[i] = item;
                return true;
            }
        }
        return false;

    }
    public boolean delete(String id) {
        for (int out = 0; out < items.length; out++) {
            if (items[out] != null && items[out].getId().equals(id)) {
                System.arraycopy(items, out + 1, items, out, items.length - (out + 1));
                items[99] = null;
                return true;
                }
            }
        return false;
    }

    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    public Item[] findByName(String key) {
        //массив для сохранения найденных итемов
       Item[] result = new Item[position];
       int k = 0;
       for (Item item: items) {
           if (item != null && item.getName().equals(key)) {
               result[k] = item;
               k++;
           }
       }
       return Arrays.copyOf(result, k);
    }

    public Item findById(String id) {
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }
}
