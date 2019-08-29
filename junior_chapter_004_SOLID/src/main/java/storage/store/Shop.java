package storage.store;

import storage.food.Food;

import java.time.LocalDate;
import java.util.LinkedList;

public class Shop<T extends Food> extends Store {
    @Override
    public void predicateSort(LinkedList list, Object obj, LocalDate date) {
        float procentTrash = ((Food) obj).procTrash(date);
        if (procentTrash >= 25 && procentTrash <= 75) {
            this.foodList.add(obj);
        } else if (procentTrash > 75 && procentTrash < 100) {
            ((Food) obj).setDisscount((short) 50);
            this.foodList.add(obj);
        }
    }
}
