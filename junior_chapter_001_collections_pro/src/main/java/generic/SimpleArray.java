package generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] objects;
    private int index;

    /**
     * конструктор
     * @param size число объектов
     */
    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    /**
     * добавление объектов
     * @param model объект для добавления
     */
    public void add(T model) {
        if (this.index >= objects.length) {
            throw new NullPointerException("Массив заполнен");
        }
        this.objects[this.index++] = model;
    }

    /**
     * проверка выхода индекса за границы диапазона массива
     * @param index индекс оъекта
     * @return true - если такой инденкс есть в массиве
     */
    private boolean checkIdex(int index) {
       return index >= 0 && index < this.objects.length;
    }

    /**
     * замена объекта
     * @param index индекс заменяемого объекта
     * @param model объект
     */
    public void set(int index, T model) {
        if (!checkIdex(index)) {
            throw new NullPointerException("Выход за границы массива");
        }
        this.objects[index] = model;
    }

    /**
     * удаление объекта из массива
     * @param index индекс удаляемого объекта
     */
    public void remove(int index) {
        if (!checkIdex(index)) {
            throw new NullPointerException("Выход за границы массива");
        }
        System.arraycopy(this.objects, index, this.objects, index + 1, this.objects.length - index - 1);
        this.objects[this.objects.length - 1] = null;
    }

    /**
     * получение объекта из массива
     * @param index идекс объекта
     * @return
     */
    public T get(int index) {
        if (!checkIdex(index)) {
            throw new NullPointerException("Выход за границы массива");
        }
        return (T) this.objects[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int idexIter = 0;
            @Override
            public boolean hasNext() {
                return idexIter < objects.length;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Объект отсутствует");
                }
                return (T) objects[index++];
            }
        };
    }
}
