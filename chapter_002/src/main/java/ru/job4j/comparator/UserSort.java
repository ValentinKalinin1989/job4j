package ru.job4j.comparator;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UserSort {
    public Set<User> sort(List<User> users) {
        Set<User> userSet = new TreeSet<User>();
        for (User user
                : users) {
            userSet.add(user);
        }
        return userSet;
    }
}
