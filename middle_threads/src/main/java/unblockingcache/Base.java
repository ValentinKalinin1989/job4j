package unblockingcache;

import java.util.Objects;

public class Base {
    private int id;
    private int vesion;

    public Base(int id, int vesion) {
        this.id = id;
        this.vesion = vesion;
    }

    public int getId() {
        return id;
    }

    public int getVesion() {
        return vesion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVesion(int vesion) {
        this.vesion = vesion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Base base = (Base) o;
        return id == base.id
                && vesion == base.vesion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vesion);
    }
}
