package list;

public class SimpleStack<T> {

    private SimpleArrayList<T> simpleArrayList = new SimpleArrayList<T>();

    public void push(T value) {
        simpleArrayList.add(value);
    }

    public T poll() {
        return simpleArrayList.delete();
    }
}

