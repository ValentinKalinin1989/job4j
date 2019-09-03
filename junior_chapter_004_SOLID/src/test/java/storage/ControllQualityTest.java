package storage;

import org.junit.Test;
import storage.food.Cheese;
import storage.food.Food;
import storage.food.Meat;
import storage.food.Milk;
import storage.food.Flour;
import storage.food.Potatoes;
import storage.sort.ControllQuality;
import storage.store.*;

import java.time.LocalDate;
import java.util.LinkedList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ControllQualityTest {
    @Test
    public void whenTestStorage() {
        Shop shop = new Shop();
        Trash trash = new Trash();
        Warehouse warehouse = new Warehouse();
        RefreshWarehouse refreshWarehouse = new RefreshWarehouse<>(warehouse);
        RestoreWare restoreWare = new RestoreWare(trash);
        ControllQuality controllQuality = new ControllQuality();
        controllQuality.addStore(trash);
        controllQuality.addStore(warehouse);
        controllQuality.addStore(restoreWare);
        controllQuality.addStore(refreshWarehouse);
        controllQuality.addStore(shop);
        Milk milk = new Milk("MilkSuper",
                LocalDate.of(2060, 7, 9),
                LocalDate.of(2019, 8, 3),
                456,
                (short) 0);
        Potatoes potatoes = new Potatoes("Potatoes",
                LocalDate.of(2060, 7, 9),
                LocalDate.of(2019, 8, 3),
                456,
                (short) 0);
        Meat meat = new Meat("MeatSuper",
                LocalDate.of(2018, 7, 9),
                LocalDate.of(2008, 8, 3),
                456,
                (short) 0);
        Flour flour = new Flour("SuperFlour",
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
        listFood.add(cheese);
        listFood.add(cheeseS);
        listFood.add(milk);
        listFood.add(potatoes);
        listFood.add(meat);
        listFood.add(flour);
        controllQuality.sort(listFood, LocalDate.of(2019, 8, 24));
        assertThat(((Milk) warehouse.getFood(0)).getName(), is("MilkSuper"));
        assertThat(((Meat) trash.getFood(0)).getName(), is("MeatSuper"));
        assertThat(((Cheese) shop.getFood(0)).getName(), is("Cheese"));
        assertThat(((Cheese) shop.getFood(1)).getName(), is("CheeseSuper"));
        assertThat(((Cheese) shop.getFood(0)).getDisscount(), is((short) 50));
        assertThat(((Flour) restoreWare.getFood(0)).getName(), is("SuperFlour"));
        assertThat(((Potatoes) refreshWarehouse.getFood(0)).getName(), is("Potatoes"));

        controllQuality.resort(LocalDate.of(2090, 8, 9));

        assertThat(((Meat) trash.getFood(0)).getName(), is("MeatSuper"));
        assertThat(((Flour) trash.getFood(1)).getName(), is("SuperFlour"));
        assertThat(((Milk) trash.getFood(2)).getName(), is("MilkSuper"));
        assertThat(((Flour) restoreWare.getFood(0)).getName(), is("SuperFlour"));



    }
}

