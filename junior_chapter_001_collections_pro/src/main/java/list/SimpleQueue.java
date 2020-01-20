package list;

public class SimpleQueue<T> {

    private SimpleArrayList<T> push = new SimpleArrayList<T>();
    private SimpleArrayList<T> poll = new SimpleArrayList<T>();
    //int size = 0;

    /**
     * добавление объекта в список для довления
     *
     * @param value
     */
    public void push(T value) {
        push.add(value);
        //size++;
    }

    /**
     * разворачивает список наоборот, удаляет значение, и опять разворачивает список
     *
     * @param
     */
    public T poll() {
        if (poll.getSize() == 0) {
            while (push.getSize() != 0) {
                poll.add(push.delete());
            }
        }
        return poll.delete();
    }
}
