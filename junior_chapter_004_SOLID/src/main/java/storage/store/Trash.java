package storage.store;

import storage.food.Food;

import java.time.LocalDate;
import java.util.LinkedList;

public class Trash<T extends Food> extends Store {
    public boolean predicateSort(LinkedList list, Object obj, LocalDate date) {
        boolean result = false;
        float procentTrash = ((Food) obj).procTrash(date);
        if (procentTrash >= 100) {
            result = true;
        }
        return result;
    }
}
