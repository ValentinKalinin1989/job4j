import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class UserStoreTest {
    @Test
    public void test() {
        UserStore<User> store = new UserStore<>();
        store.add(new User(1, 100));
        store.add(new User(2, 200));
        assertThat(store.transfer(1, 2, 50), is(true));
        assertThat(store.getUserForIdex(0).getAmount(), is(50));
        assertThat(store.getUserForIdex(1).getAmount(), is(250));
    }
}
