package storage.food;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Food {
    @Setter @Getter private String name;
    @Setter @Getter private LocalDate expaireDate;
    @Setter @Getter private LocalDate createDate;
    @Setter @Getter private float price;
    @Setter @Getter private short disscount;

        public Food(String name, LocalDate expaireDate, LocalDate createDate, float price, short disscount) {
            this.name = name;
            this.expaireDate = expaireDate;
            this.createDate = createDate;
            this.price = price;
            this.disscount = disscount;
        }
    /**
     * опеределение процента истекшего срока годности на выбранную дату
     * @param date дата, на котороую необходимо определить процент
     * @return процент истекшего строка годности
     */
    public float procTrash(LocalDate date) {
            float dayzAllStore = (float) ChronoUnit.DAYS.between(this.getCreateDate(), this.getExpaireDate());
            float daysLate = (float) ChronoUnit.DAYS.between(this.getCreateDate(), date);
            return (daysLate / dayzAllStore) * 100;
        }
    }




