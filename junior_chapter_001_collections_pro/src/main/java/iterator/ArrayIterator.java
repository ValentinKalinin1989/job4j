package iterator;

import java.util.Iterator;
<<<<<<< HEAD
<<<<<<< HEAD
import java.util.NoSuchElementException;
=======
>>>>>>> task_144035
=======
>>>>>>> task_144036

public class ArrayIterator implements Iterator {

    private final int[][] arrayInt;
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> task_144036
    private int indexOut = 0;
    private int indexIn = 0;

    
    public ArrayIterator(final int[][] arrayInt) {
        this.arrayInt = arrayInt;
<<<<<<< HEAD
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
=======
>>>>>>> task_144036
    }
    @Override
    public boolean hasNext() {

<<<<<<< HEAD
<<<<<<< HEAD
        return arrayInt.length > indexOut && arrayInt[indexOut].length > indexIn;
=======
        return arrayLenght > index;
>>>>>>> task_144035
=======
        return arrayInt.length > indexOut && arrayInt[indexOut].length > indexIn;
>>>>>>> task_144036
    }

    @Override
    public Integer next() {
<<<<<<< HEAD
<<<<<<< HEAD
        if (!hasNext()) {
            throw new NoSuchElementException("Нет элементов.");
        }
=======
>>>>>>> task_144036
        Integer result = this.arrayInt[indexOut][indexIn];
        indexIn++;
        if (indexIn >= this.arrayInt[indexOut].length) {
            indexOut++;
            indexIn = 0;
        }
<<<<<<< HEAD
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
=======
>>>>>>> task_144036
        return result;
    }

    @Override
    public void remove() {
<<<<<<< HEAD
<<<<<<< HEAD
        throw new UnsupportedOperationException("Операция не поддерживается.");
=======

>>>>>>> task_144035
=======
        throw new UnsupportedOperationException("Операция не поддерживается");
>>>>>>> task_144036
    }
}
