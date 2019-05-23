package iterator;

import java.util.Iterator;

public class ArrayIterator implements Iterator {

    private final int[][] arrayInt;
    private int index = 0;
    private int arrayLenght = 0;
    
    public ArrayIterator(final int[][] arrayInt) {
        this.arrayInt = arrayInt;
        for (int[] arrayOut: arrayInt) {
            for (int in : arrayOut) {
                arrayLenght++;
            }
        }
    }
    @Override
    public boolean hasNext() {

        return arrayLenght > index;
    }

    @Override
    public Integer next() {
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
        return result;
    }

    @Override
    public void remove() {

    }
}
