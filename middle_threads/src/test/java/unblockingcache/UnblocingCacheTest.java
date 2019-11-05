package unblockingcache;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UnblocingCacheTest {
        @Test
        public void whenThrowException() throws InterruptedException {
            UnblockingCache unblockingCache = new UnblockingCache();
            Base model = new Base(1, 1);
            unblockingCache.add(model);
            AtomicReference<Exception> ex = new AtomicReference<>();
            Thread thread1 = new Thread(
                    () -> {
                        try {
                            unblockingCache.update(model);
                        } catch (Exception e) {
                            ex.set(e);
                        }
                    }
            );
            Thread thread2 = new Thread(
                    () -> {
                        try {
                            unblockingCache.update(new Base(1, 1));
                        } catch (Exception e) {
                            ex.set(e);
                        }
                    }
            );

            thread1.start();
            thread1.join();
            thread2.start();
            thread2.join();
            assertThat(ex.get().getMessage(), is("OptimisticException"));
        }
}
