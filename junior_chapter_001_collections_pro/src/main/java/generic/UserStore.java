package generic;

public class UserStore<T extends User> extends AbstractStore {
    public UserStore(int size) {
        super(size);
    }
}
