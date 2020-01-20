package ru.job4j.tracker;

public enum TrackerEnum {
    INSTANCE;
    Tracker tracker = new Tracker();

    public Item add(Item item) {
        tracker.add(item);
        return item;
    }
}
