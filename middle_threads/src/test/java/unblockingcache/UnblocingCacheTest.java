package unblockingcache;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UnblocingCacheTest {
        @Test
        public void whenThrowException() throws InterruptedException {
            UnblockingCache cache = new UnblockingCache();
            Base testBase = new Base(1, 1);
            cache.add(new Base(2, 1));
            cache.add(new Base(3, 1));
            cache.add(new Base(4, 1));
            AtomicReference<Exception> ex = new AtomicReference<>();
            Thread firstThread = new Thread(
                    () -> {
                        try {
                            cache.update(testBase);
                        } catch (Exception e) {
                            ex.set(e);
                        }
                    }
            );
            Thread secondThread = new Thread(
                    () -> {
                        try {
                            cache.update(testBase);
                        } catch (Exception e) {
                            ex.set(e);
                        }
                    }
            );


            Thread thirdThread = new Thread(
                    () -> {
                        try {
                            cache.update(testBase);
                        } catch (Exception e) {
                            ex.set(e);
                        }
                    }
            );
            Thread fourThread = new Thread(
                    () -> {
                        try {
                            cache.update(testBase);
                        } catch (Exception e) {
                            ex.set(e);
                        }
                    }
            );

            firstThread.start();
            secondThread.start();
            //thirdThread.start();
            //fourThread.start();
            //firstThread.join();
            //secondThread.join();
            //fourThread.join();
            //thirdThread.join();
            assertThat(ex.get().getMessage(), is("OptimisticException"));
        }
}
