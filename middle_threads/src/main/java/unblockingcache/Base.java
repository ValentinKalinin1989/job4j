package unblockingcache;

import java.util.Objects;

public class Base {
    private int id;
    private int versionBase;

    public Base(int id, int vesionBase) {
        this.id = id;
        this.versionBase = vesionBase;
    }

    public int getId() {
        return id;
    }

    public int getVersionBase() {
        return versionBase;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVersionBase(int versionBase) {
        this.versionBase = versionBase;
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
                && versionBase == base.versionBase;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, versionBase);
    }
}
