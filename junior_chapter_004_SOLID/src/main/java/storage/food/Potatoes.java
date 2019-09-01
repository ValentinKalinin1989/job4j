package storage.food;

import java.time.LocalDate;

public class Potatoes extends Food {
    public Potatoes(String name, LocalDate expaireDate, LocalDate createDate, float price, short disscount) {
        super(name, expaireDate, createDate, price, disscount);
    }

    @Override
    public boolean isVegetable() {
        return true;
    }
}
