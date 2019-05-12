package ru.job4j.comparator;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class UserSort {
    public Set<User> sort(List<User> users) {
        Set<User> userSet = new TreeSet<User>();
        for (User user
                : users) {
            userSet.add(user);
        }
        return userSet;
    }

    public List<User> sortNameLength(List<User> users) {

        return users.stream().sorted(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }).collect(Collectors.toList());


    }

    public List<User> sortByAllFields(List<User> users) {
        return users.stream().sorted(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int numberComp = o1.getName().compareTo(o2.getName());
                return ((numberComp == 0)
                        ? o1.getAge().compareTo(o2.getAge()) : numberComp);
            }
        }).collect(Collectors.toList());
    }
}
