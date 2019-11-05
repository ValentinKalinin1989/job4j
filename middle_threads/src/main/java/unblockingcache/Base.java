package unblockingcache;

public class Base {
    private int id;
    private int version;

    public Base(int id, int vesion) {
        this.id = id;
        this.version = vesion;
    }

    public int getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
