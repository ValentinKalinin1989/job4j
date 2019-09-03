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
            list.forEach(food -> {
                if (predicateSort(list, food, date)) {
                    foodList.add(food);
                }
            });
        }
    }

    public boolean predicateSort(LinkedList<Food> list, Food food, LocalDate date) {
        return false;
    }

    public Food getFood(int index) {
        return foodList.get(index);
    }

    public LinkedList<Food> getFoodList() {

        return this.foodList;
    }

    public void toClearStore() {
        this.foodList.clear();
    }

}
