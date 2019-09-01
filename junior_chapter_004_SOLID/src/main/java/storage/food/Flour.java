package storage.food;

import java.time.LocalDate;

public class Flour extends  Food {
    public Flour(String name, LocalDate expaireDate, LocalDate createDate, float price, short disscount) {
        super(name, expaireDate, createDate, price, disscount);
    }

    @Override
    public boolean isCanReproduction() {
        return true;
    }
}
