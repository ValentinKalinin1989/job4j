
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

public class User {
    @Getter @Setter private int id;
    @Getter @Setter private int amount;

    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id == user.id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
