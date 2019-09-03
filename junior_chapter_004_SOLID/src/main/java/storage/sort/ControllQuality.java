package storage.sort;

import storage.food.Food;
import storage.store.Store;

import java.time.LocalDate;
import java.util.LinkedList;

public class ControllQuality {

    private LinkedList<Store> listStores;

    public void addStore(Store store) {
        listStores.add(store);
    }

    public ControllQuality() {
        this.listStores = new LinkedList<>();
    }

    public void sort(LinkedList<Food> foodList, LocalDate date) {
        this.listStores.forEach(store -> {
            store.addFood(foodList, date);
        });
    }

    public void resort(LocalDate date) {
        LinkedList<Food> foodList = new LinkedList<>();
        listStores.forEach(store -> {
            foodList.addAll(store.getFoodList());
            store.toClearStore();
        });
        sort(foodList, date);
    }
}
