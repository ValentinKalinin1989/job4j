import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

//очередь с ограничением по хранению 10 элементов
@ThreadSafe
public class SimpleBlockingQueue<T> {
    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();
    private int limit;

    public SimpleBlockingQueue(int limit) {
        this.limit = limit;
    }

    public synchronized void offer(T value) throws InterruptedException {
        while (this.queue.size() == this.limit) {
            wait();
        }
        if (this.queue.size() == 0) {
            notifyAll();
        }
        this.queue.add(value);
    }

    public synchronized T poll() throws InterruptedException {
        while (this.queue.size() == 0) {
            wait();
        }
        if (this.queue.size() == this.limit) {
            notifyAll();
        }
        this.notify();
        return queue.poll();
    }

    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }
}
