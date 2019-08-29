package storage.food;

import java.time.LocalDate;

public class Meat extends Food {
    public Meat(String name, LocalDate expaireDate, LocalDate createDate, float price, short disscount) {
        super(name, expaireDate, createDate, price, disscount);
    }
}
