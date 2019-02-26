package ru.job4j.tracker;

public class TrackerStaticField {
    public static TrackerStaticField instance;

    Tracker tracker = new Tracker();

    private TrackerStaticField() {

    }

    public static TrackerStaticField getInstance() {
        if (instance == null) {
            instance = new TrackerStaticField();
        }
        return instance;
    }

    public Item add(Item item) {
        tracker.add(item);
        return item;
    }

}
