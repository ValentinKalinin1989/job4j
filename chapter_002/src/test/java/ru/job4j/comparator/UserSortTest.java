package ru.job4j.comparator;

import org.junit.Test;
import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserSortTest {
    @Test
    public void whenTestComparator() {
        List<User> users = List.of(
                new User("", 34),
                new User("", 22),
                new User("", 25),
                new User("", 60)
        );

        UserSort sort = new UserSort();

        Set<User> userSet = sort.sort(users);

        List<User> userTest = new ArrayList<User>(userSet);

        assertThat(22, is(userTest.get(0).getAge()));
        assertThat(25, is(userTest.get(1).getAge()));
        assertThat(34, is(userTest.get(2).getAge()));
        assertThat(60, is(userTest.get(3).getAge()));
    }

    @Test
    public void whenTestsortNameLength() {
        List<User> users = List.of(
                new User("Андрей", 11),
                new User("Петр", 11),
                new User("Евгений", 11),
                new User("Василий", 60)
        );

        UserSort sort = new UserSort();

        List<User> userTest = sort.sortNameLength(users);


        assertThat("Андрей", is(userTest.get(0).getName()));
        assertThat("Василий", is(userTest.get(1).getName()));
        assertThat("Евгений", is(userTest.get(2).getName()));
        assertThat("Петр", is(userTest.get(3).getName()));
    }

    @Test
    public void whenTestsortByAllFields() {
        List<User> users = List.of(
                new User("Сергей", 25),
                new User("Иван", 30),
                new User("Сергей", 20),
                new User("Иван", 25)
        );

        UserSort sort = new UserSort();

        List<User> userTest = sort.sortByAllFields(users);


        assertThat("Иван", is(userTest.get(0).getName()));
        assertThat("Иван", is(userTest.get(1).getName()));
        assertThat("Сергей", is(userTest.get(2).getName()));
        assertThat("Сергей", is(userTest.get(3).getName()));

        assertThat(25, is(userTest.get(0).getAge()));
        assertThat(30, is(userTest.get(1).getAge()));
        assertThat(20, is(userTest.get(2).getAge()));
        assertThat(25, is(userTest.get(3).getAge()));
    }

}
