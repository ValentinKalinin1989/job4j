package ru.job4j.tracker;

import java.util.List;
import java.util.HashMap;

public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> mapUsers = new HashMap<>();
        for (User userFromList
                : list) {
            mapUsers.put(userFromList.getId(), userFromList);
        }
        return mapUsers;
    }
}
