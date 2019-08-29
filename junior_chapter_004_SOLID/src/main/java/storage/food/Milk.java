package storage.food;

import java.time.LocalDate;

public class Milk extends Food {
    public Milk(String name, LocalDate expaireDate, LocalDate createDate, float price, short disscount) {
        super(name, expaireDate, createDate, price, disscount);
    }

}
