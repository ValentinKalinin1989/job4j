package iterator;

import java.util.Iterator;
<<<<<<< HEAD
import java.util.NoSuchElementException;
=======
>>>>>>> task_144035

public class ArrayIterator implements Iterator {

    private final int[][] arrayInt;
<<<<<<< HEAD
    private int indexOut = 0;
    private int indexIn = 0;

    
    public ArrayIterator(final int[][] arrayInt) {
        this.arrayInt = arrayInt;
=======
    private int index = 0;
    private int arrayLenght = 0;
    
    public ArrayIterator(final int[][] arrayInt) {
        this.arrayInt = arrayInt;
        for (int[] arrayOut: arrayInt) {
            for (int in : arrayOut) {
                arrayLenght++;
            }
        }
>>>>>>> task_144035
    }
    @Override
    public boolean hasNext() {

<<<<<<< HEAD
        return arrayInt.length > indexOut && arrayInt[indexOut].length > indexIn;
=======
        return arrayLenght > index;
>>>>>>> task_144035
    }

    @Override
    public Integer next() {
<<<<<<< HEAD
        if (!hasNext()) {
            throw new NoSuchElementException("Нет элементов.");
        }
        Integer result = this.arrayInt[indexOut][indexIn];
        indexIn++;
        if (indexIn >= this.arrayInt[indexOut].length) {
            indexOut++;
            indexIn = 0;
        }
=======
        int indexForNext = 0;
        Integer result = null;
        for (int[] arrayOut: arrayInt) {
            for (int in: arrayOut) {
                if (indexForNext == this.index) {
                    result = in;
                }
                indexForNext++;
            }
        }
        this.index++;
>>>>>>> task_144035
        return result;
    }

    @Override
    public void remove() {
<<<<<<< HEAD
        throw new UnsupportedOperationException("Операция не поддерживается.");
=======

>>>>>>> task_144035
    }
}
