package ru.job4j.comparator;

import org.junit.Test;
import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserSortTest {
    @Test
    public void whenTestComparator() {
        List<User> users = new ArrayList<>(4);
        users.add(new User("", 34));
        users.add(new User("", 22));
        users.add(new User("", 25));
        users.add(new User("", 60));

        UserSort sort = new UserSort();

        Set<User> userSet = sort.sort(users);

        List<User> userTest = new ArrayList<User>(userSet);

        assertThat(22, is(userTest.get(0).getAge()));
        assertThat(25, is(userTest.get(1).getAge()));
        assertThat(34, is(userTest.get(2).getAge()));
        assertThat(60, is(userTest.get(3).getAge()));
    }
}
