package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator {
    private final int[] arrayInt;
    private int index = 0;

    public EvenNumbersIterator(final int[] arrayInt) {
        this.arrayInt = arrayInt;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int i = index; i < arrayInt.length; i++) {
            if (hasElement(i)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Integer next() {
        Integer result = null;
        for (int i = index; i < arrayInt.length; i++) {
            if (hasElement(i)) {
                result = this.arrayInt[i];
                index = i + 1;
                break;
            }
        }
        if (result == null) {
            throw new NoSuchElementException();
        }
        return result;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Данная операция не поддерживается");
    }

    /**
     * проверка наличия четного элементв по идексу
     * @param indexElement индес элемента
     * @return четный элемент или нет
     */
    private boolean hasElement(int indexElement) {
        return this.arrayInt[indexElement] % 2 == 0;
    }
}
