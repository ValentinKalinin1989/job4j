package ru.job4j.tracker;

public class TrackerStaticFinalField {
    private static final TrackerStaticFinalField INSTANCE = new TrackerStaticFinalField();

    private TrackerStaticFinalField() {

    }

    public static TrackerStaticFinalField getInstance() {
        return INSTANCE;
    }

    Tracker tracker = new Tracker();

    public Item add(Item item) {
        tracker.add(item);
        return item;
    }
}
