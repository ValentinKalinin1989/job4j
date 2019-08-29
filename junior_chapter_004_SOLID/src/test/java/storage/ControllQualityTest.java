package storage;

import org.junit.Test;
import storage.food.Cheese;
import storage.food.Food;
import storage.food.Meat;
import storage.food.Milk;
import storage.sort.ControllQuality;
import storage.store.Shop;
import storage.store.Trash;
import storage.store.Warehouse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ControllQualityTest {
    @Test
    public void whenTestStorage() {
        Shop shop = new Shop();
        Trash trash = new Trash();
        Warehouse warehouse = new Warehouse();
        ControllQuality controllQuality = new ControllQuality();
        controllQuality.addStore(shop);
        controllQuality.addStore(trash);
        controllQuality.addStore(warehouse);
        Milk milk = new Milk("MilkSuper",
                LocalDate.of(2060, 7, 9),
                LocalDate.of(2019, 8, 3),
                456,
                (short) 0);
        Meat meat = new Meat("MeatSuper",
                LocalDate.of(2018, 7, 9),
                LocalDate.of(2008, 8, 3),
                456,
                (short) 0);
        Cheese cheese = new Cheese("Cheese",
                LocalDate.of(2020, 7, 9),
                LocalDate.of(2009, 8, 3),
                456,
                (short) 0);
        Cheese cheeseS = new Cheese("CheeseSuper",
                LocalDate.of(2024, 8, 9),
                LocalDate.of(2015, 8, 3),
                456,
                (short) 0);
        LinkedList<Food> listFood = new LinkedList<>();
        listFood.add(milk);
        listFood.add(meat);
        listFood.add(cheese);
        listFood.add(cheeseS);
        controllQuality.sort(listFood, LocalDate.of(2019, 8, 24));
        assertThat(((Milk) warehouse.getFood(0)).getName(), is("MilkSuper"));
        assertThat(((Meat) trash.getFood(0)).getName(), is("MeatSuper"));
        assertThat(((Cheese) shop.getFood(0)).getName(), is("Cheese"));
        assertThat(((Cheese) shop.getFood(1)).getName(), is("CheeseSuper"));
        assertThat(((Cheese) shop.getFood(0)).getDisscount(), is((short) 50));
    }
}
