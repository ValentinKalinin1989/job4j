package storage.store;

import storage.food.Food;

import java.time.LocalDate;
import java.util.LinkedList;

public class Shop<T extends Food> extends Store {
    @Override
    public boolean predicateSort(LinkedList list, Object obj, LocalDate date) {
        boolean result = false;
        float procentTrash = ((Food) obj).procTrash(date);
        if (procentTrash >= 25 && procentTrash <= 75) {
            result = true;
        } else if (procentTrash > 75 && procentTrash < 100) {
            ((Food) obj).setDisscount((short) 50);
            result = true;
        }
        return result;
    }
}
