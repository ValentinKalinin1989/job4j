/*
import org.junit.Test;
import threadpool.SimpleBlockingQueue;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleBlockingQueueTest {

    private class ThreadOffer extends Thread {
        private SimpleBlockingQueue<Integer> queueTest;
        private Integer value;

        public ThreadOffer(SimpleBlockingQueue queueTest, Integer value) {
            this.queueTest = queueTest;
            this.value = value;
        }
        @Override
        public void run() {
            try {
                this.queueTest.offer(value);
                System.out.println("Добавлено значение" + value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class ThreadPoll extends Thread {
        private SimpleBlockingQueue<Integer> queueTest;
        private Integer value;

        public ThreadPoll(SimpleBlockingQueue queueTest) {
            this.queueTest = queueTest;
        }
        @Override
        public void run() {
            try {
                this.value = this.queueTest.poll();
                System.out.println("Извлечено значение" + value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        public Integer getValue() {
            return this.value;
        }
    }

    @Test
    public void testOfferElevenNumbbersAndGetThreLastNumber() {
        SimpleBlockingQueue<Integer> queueTest = new SimpleBlockingQueue<>(10);
        for (int i = 0; i < 10; i++) {
            Thread thread = new ThreadOffer(queueTest, i + 1);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //создаем 11 поток, который будет ожидать освобождения стека
        Thread lastThread =  new ThreadOffer(queueTest, 11);
        lastThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //получение статуса добавления 11 значения в очередь, должен ожидать (WAITING)
        String state = lastThread.getState().name();
        Thread getFirstLast = new ThreadPoll(queueTest);
        getFirstLast.start();
        Thread getSecondLast = new ThreadPoll(queueTest);
        getSecondLast.start();
        try {
            getFirstLast.join();
            getSecondLast.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Integer firstLast = ((ThreadPoll) getFirstLast).getValue();
        Integer secondFirst = ((ThreadPoll) getSecondLast).getValue();
        assertThat(firstLast, is(1));
        assertThat(secondFirst, is(2));
        assertThat(state, is("WAITING"));
    }

}

 */
