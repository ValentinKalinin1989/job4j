package storage.food;

import java.time.LocalDate;

public class Cheese extends Food {
    public Cheese(String name, LocalDate expaireDate, LocalDate createDate, float price, short disscount) {
        super(name, expaireDate, createDate, price, disscount);
    }
}
