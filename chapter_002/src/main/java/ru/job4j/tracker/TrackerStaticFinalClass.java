package ru.job4j.tracker;

public class TrackerStaticFinalClass {
    private TrackerStaticFinalClass() {

    }

    private static final class Holder {
        private static final TrackerStaticFinalClass INSTACE = new TrackerStaticFinalClass();
    }

    public static TrackerStaticFinalClass getInstance() {
        return Holder.INSTACE;
    }

    Tracker tracker = new Tracker();

    public Item add(Item item) {
        tracker.add(item);
        return item;
    }
}
