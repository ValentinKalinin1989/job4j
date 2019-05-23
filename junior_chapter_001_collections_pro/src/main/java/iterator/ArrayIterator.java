package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator implements Iterator {

    private final int[][] arrayInt;
    private int indexOut = 0;
    private int indexIn = 0;

    
    public ArrayIterator(final int[][] arrayInt) {
        this.arrayInt = arrayInt;
    }
    @Override
    public boolean hasNext() {

        return arrayInt.length > indexOut && arrayInt[indexOut].length > indexIn;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Нет элементов.");
        }
        Integer result = this.arrayInt[indexOut][indexIn];
        indexIn++;
        if (indexIn >= this.arrayInt[indexOut].length) {
            indexOut++;
            indexIn = 0;
        }
        return result;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Операция не поддерживается.");
    }
}
