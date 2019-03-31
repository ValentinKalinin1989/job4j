package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.list.ConvertMatrix2List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void whenTestUser() {
        List<User> listUser = new ArrayList<>();
        listUser.add(new User(12, "Ivan", "Tula"));
        listUser.add(new User(22, "Petr", "Moscow"));
        listUser.add(new User(345, "Jems", "London"));

        UserConvert userConvert = new UserConvert();

        HashMap<Integer, User> mapUser = userConvert.process(listUser);

        assertThat(mapUser.get(12), is(new User(12, "Ivan", "Tula")));
        assertThat(mapUser.get(345), is(new User(345, "Jems", "London")));
        assertThat(mapUser.get(22), is(new User(22, "Petr", "Moscow")));

    }
}