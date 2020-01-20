package storage.food;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Food implements Vegetable, Reproduction {

    private String name;

    private LocalDate expaireDate;

    private LocalDate createDate;

    private float price;

    private short disscount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getExpaireDate() {
        return expaireDate;
    }

    public void setExpaireDate(LocalDate expaireDate) {
        this.expaireDate = expaireDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public short getDisscount() {
        return disscount;
    }

    public void setDisscount(short disscount) {
        this.disscount = disscount;
    }

    public Food(String name, LocalDate expaireDate, LocalDate createDate, float price, short disscount) {
        this.name = name;
        this.expaireDate = expaireDate;
        this.createDate = createDate;
        this.price = price;
        this.disscount = disscount;
    }

    /**
     * опеределение процента истекшего срока годности на выбранную дату
     *
     * @param date дата, на котороую необходимо определить процент
     * @return процент истекшего строка годности
     */
    public float procTrash(LocalDate date) {
        float dayzAllStore = (float) ChronoUnit.DAYS.between(this.getCreateDate(), this.getExpaireDate());
        float daysLate = (float) ChronoUnit.DAYS.between(this.getCreateDate(), date);
        return (daysLate / dayzAllStore) * 100;
    }

    @Override
    public boolean isCanReproduction() {
        return false;
    }

    @Override
    public boolean isVegetable() {
        return false;
    }
}




