package generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] objects;
    private int index = 0;

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
     * @return true если операция успешна
     */
    public boolean add(T model) {
        if (this.index >= objects.length) {
            throw new NullPointerException("Массив заполнен");
        }
        this.objects[this.index++] = model;
        return true;
    }

    /**
     * проверка выхода индекса за границы диапазона массива
     * @param index индекс оъекта
     * @return true - если такой инденкс есть в массиве
     */
    private boolean checkIdex(int index) {
        if (index < 0 && index >= this.index) {
            throw new NullPointerException("Выход за пределы добавленных элементов");
        }
        return true;
    }

    /**
     * замена объекта
     * @param index индекс заменяемого объекта
     * @param model объект
     * @return true если операция успешна
     */
    public boolean set(int index, T model) {
        checkIdex(index);
        this.objects[index] = model;
        return true;
    }

    /**
     * удаление объекта из массива
     * @param index индекс удаляемого объекта
     * @return true если операция успешна
     */
    public boolean remove(int index) {
        checkIdex(index);
        System.arraycopy(this.objects, index, this.objects, index + 1, this.objects.length - index - 1);
        this.objects[this.objects.length - 1] = null;
        this.index--;
        return true;
    }

    /**
     * получение объекта из массива
     * @param index идекс объекта
     * @return объект
     */
    public T get(int index) {
        checkIdex(index);
        return (T) this.objects[index];
    }

    /**
     * получение индекса элемента
     * @return индекс элемента
     */
    public int getIndexE() {
        return this.index;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int idexIter = 0;
            @Override
            public boolean hasNext() {
                return idexIter < index;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Объект отсутствует");
                }
                return (T) objects[idexIter++];
            }
        };
    }
}
