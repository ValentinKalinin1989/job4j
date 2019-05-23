package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ArrayList;

public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private Iterator<Integer> iterator = (new ArrayList<Integer>()).iterator();
            @Override
            public boolean hasNext() {

                while (it.hasNext() && !iterator.hasNext()) {
                    iterator = it.next();
                }
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return iterator.next();
            }
            @Override
            public void remove() {
                throw new UnsupportedOperationException("Operation remove unsupported.");
            }
        };
    }
}
