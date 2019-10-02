import list.ArrayListForStudy;
import net.jcip.annotations.ThreadSafe;
import net.jcip.annotations.GuardedBy;

import java.util.Iterator;

@ThreadSafe
public class ThreadSafeList<E> implements Iterable<E> {
    @GuardedBy("this")
    private ArrayListForStudy arrayList;

    public ThreadSafeList() {
        this.arrayList = new ArrayListForStudy();
    }

    public synchronized void add(E value) {
        this.arrayList.add(value);
    }

    public synchronized E get(int index) {
        return (E) this.arrayList.get(index);
    }

    @Override
    public synchronized Iterator<E> iterator() {
        return copy(this.arrayList).iterator();
    }

    private ArrayListForStudy copy(ArrayListForStudy listToCopy) {
        ArrayListForStudy copyList = listToCopy;
        return copyList;
    }
}
