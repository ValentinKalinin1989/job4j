package generic;

public abstract class AbstractStore implements Store {

    private SimpleArray<Base> simpleArray;

    public AbstractStore(int size) {
        this.simpleArray = new SimpleArray<Base>(size);
    }
    @Override
    public void add(Base model) {
        simpleArray.add(model);
    }

    @Override
    public boolean replace(String id, Base model) {
        return simpleArray.set((int) Integer.parseInt(id), model);
    }

    @Override
    public boolean delete(String id) {
        return simpleArray.remove((int) Integer.parseInt(id));
    }

    @Override
    public Base findById(String id) {
        return simpleArray.get((int) Integer.parseInt(id));
    }
}
