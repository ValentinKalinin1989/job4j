package storage.store;

import storage.food.Food;

import java.time.LocalDate;
import java.util.LinkedList;

public class RestoreWare<T extends Food> extends Store {
    Store store;

    public RestoreWare(Store store) {
        this.store = store;
    }

    public boolean predicateSort(LinkedList list, Object obj, LocalDate date) {
        boolean result = false;
        if (store.predicateSort(list, obj, date) && ((Food) obj).isCanReproduction()) {
            result = true;
        }
        return result;
    }
}
