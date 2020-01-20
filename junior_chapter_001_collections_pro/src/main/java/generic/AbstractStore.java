package generic;

public abstract class AbstractStore<E extends Base> implements Store<E> {

    private SimpleArray<E> simpleArray;

    public AbstractStore(int size) {
        this.simpleArray = new SimpleArray<E>(size);
    }

    @Override
    public void add(E model) {
        simpleArray.add(model);
    }

    @Override
    public boolean replace(String id, E model) {
        boolean result = false;
        int indexById = findIndexById(id);
        if (indexById != -1) {
            this.simpleArray.set(indexById, model);
            result = true;

        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        int indexById = findIndexById(id);
        if (indexById != -1) {
            this.simpleArray.remove(indexById);
            result = true;

        }
        return result;
    }

    @Override
    public E findById(String id) {
        E result = null;
        int indexById = findIndexById(id);
        if (indexById != -1) {
            result = this.simpleArray.get(indexById);
        }
        return result;
    }

    /**
     * поиск объекта по id
     *
     * @param id
     * @return индекс элемента, если он есть
     */
    private int findIndexById(String id) {
        int index = -1;
        int count = 0;
        while (this.simpleArray.iterator().hasNext()) {
            if (this.simpleArray.iterator().next().getId().equals(id)) {
                index = count;
                break;
            }
            count++;
        }
        return index;
    }
}


