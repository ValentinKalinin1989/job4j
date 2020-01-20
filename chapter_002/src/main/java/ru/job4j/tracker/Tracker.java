package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Tracker implements ITracker {
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
        AtomicBoolean result = new AtomicBoolean(false);
        IntStream.range(0, this.items.size())
                .filter(i -> items.get(i).getId().equals(id))
                .findFirst()
                .ifPresent(
                        i -> {
                            result.set(true);
                            items.set(i, item);
                        }
                );
        return result.get();
    }


    public boolean delete(String id) {
        AtomicBoolean result = new AtomicBoolean(false);
        IntStream.range(0, this.items.size())
                .filter(i -> items.get(i).getId().equals(id))
                .findFirst()
                .ifPresent(
                        i -> {
                            result.set(true);
                            items.remove(i);
                        }
                );
        return result.get();
    }

    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        result.addAll(0, this.items);
        return result;
    }

    public List<Item> findByName(String key) {
        return items.stream().filter(itemFilter -> itemFilter.getName().equals(key)).collect(Collectors.toList());
    }

    public Item findById(String id) {
        return items.stream().filter(itemFilter -> itemFilter.getId().equals(id)).findFirst().orElse(null);
    }

    public String getId(int i) {
        return this.items.get(i).getId();
    }

    public String getItemToString(int i) {
        return this.items.get(i).toString();
    }
}
