package generic;

public class RoleStore<T extends Role> extends AbstractStore {
    public RoleStore(int size) {
        super(size);
    }
}
