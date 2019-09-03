package storage.store;

import storage.food.Food;

import java.time.LocalDate;
import java.util.LinkedList;

public class RefreshWarehouse<T extends Food> extends Store {

    Store store;

    public RefreshWarehouse(Store store) {
        this.store = store;
    }

    public boolean predicateSort(LinkedList list, Object obj, LocalDate date) {
        boolean result = false;
        if (store.predicateSort(list, obj, date) && ((Food) obj).isVegetable()) {
            this.foodList.add(obj);
        }
        return result;
    }
}
