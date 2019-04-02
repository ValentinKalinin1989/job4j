package ru.job4j.comparator;

import org.junit.Test;
import ru.job4j.list.ConvertMatrix2List;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserTest {
    @Test
    public void whenTestComparator() {
        List<User> users = new ArrayList<>(4);
        users.add(new User("", 34));
        users.add(new User("", 22));
        users.add(new User("", 25));
        users.add(new User("", 60));

        Collections.sort(users);

        assertThat(22, is(users.get(0).getAge()));
        assertThat(25, is(users.get(1).getAge()));
        assertThat(34, is(users.get(2).getAge()));
        assertThat(60, is(users.get(3).getAge()));
    }
}
