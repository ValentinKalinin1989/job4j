package set;

import list.ArrayListForStudy;

import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {

    private ArrayListForStudy<T> arrayList = new ArrayListForStudy<>();

    /**
     * добавляет элементы в set
     *
     * @param value всталяемый елемент
     */
    public void add(T value) {
        if (!contains(value)) {
            arrayList.add(value);
        }
    }

    /**
     * проверка наличия дубля в коллекции
     *
     * @param value елемент для сравнение
     * @return true - если элемент есть, false - если элеиента нет
     */
    public boolean contains(T value) {
        boolean result = false;
        for (T element : arrayList) {
            if (value.equals(element)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return arrayList.iterator();
    }
}
