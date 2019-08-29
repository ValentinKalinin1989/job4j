package storage.store;

import java.time.LocalDate;
import java.util.LinkedList;

public abstract class Store<Food> {
    protected LinkedList<Food> foodList;

    public Store() {
        this.foodList = new LinkedList<>();
    }

    public void addFood(LinkedList<Food> list, LocalDate date) {
        if (!list.isEmpty()) {
            list.stream().forEach(food -> predicateSort(list, food, date));
        }
    }

    public void predicateSort(LinkedList<Food> list, Food food, LocalDate date) {
    }

    public Food getFood(int index) {
        return foodList.get(index);
    }

}
