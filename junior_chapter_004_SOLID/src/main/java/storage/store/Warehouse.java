package storage.store;

import storage.food.Food;

import java.time.LocalDate;
import java.util.LinkedList;

public class Warehouse<T extends Food> extends Store {
    public void predicateSort(LinkedList list, Object obj, LocalDate date) {
        float procentTrash = ((Food) obj).procTrash(date);
        if (procentTrash < 25) {
            this.foodList.add(obj);
            //list.remove(obj);
        }
    }

}
