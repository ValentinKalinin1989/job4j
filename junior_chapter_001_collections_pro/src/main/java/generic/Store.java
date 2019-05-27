package generic;

public interface Store<E extends Base> {

    void add(E model);

    boolean replace(String id, E model);

    boolean delete(String id);

    E findById(String id);
}