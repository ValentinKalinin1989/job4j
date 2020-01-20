package list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayListForStudy<E> implements Iterable<E> {
    private int size = 10;
    private Object[] container;
    private int index = 0;
    private int modCount = 0;

    public ArrayListForStudy() {
        this.container = new Object[size];
    }

    public void add(E value) {
        this.container[this.index++] = value;
        if (this.index == this.size) {
            contanierIncrease();
        }
        modCount++;
    }

    private void contanierIncrease() {
        this.size = this.size + 10;
        Object[] newContainer = new Object[this.size];
        System.arraycopy(this.container, 0, newContainer, 0, index + 1);
        this.container = newContainer;
    }

    public E get(int index) {

        return (E) Arrays.stream(this.container).skip(index).findFirst().orElse(null);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int countIter = modCount;
            private int indexIt = 0;

            @Override
            public boolean hasNext() {
                if (this.countIter != modCount) {
                    throw new ConcurrentModificationException("Размер листа был увеличен");
                }
                return this.indexIt < index;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Отсутвуют элементы");
                }
                return (E) container[this.indexIt++];
            }
        };
    }
}
