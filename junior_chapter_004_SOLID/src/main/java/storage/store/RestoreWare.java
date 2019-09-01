package storage.store;

import storage.food.Food;

import java.time.LocalDate;
import java.util.LinkedList;

public class RestoreWare<T extends Food> extends Store {
    Store store;

    public RestoreWare(Store store) {
        this.store = store;
    }

    public void predicateSort(LinkedList list, Object obj, LocalDate date) {
        float procentTrash = ((Food) obj).procTrash(date);
        if (procentTrash >= 100 && ((Food) obj).isCanReproduction()) {
            this.foodList.add(obj);
        } else {
            store.addFood(list, date);
        }
    }
}
