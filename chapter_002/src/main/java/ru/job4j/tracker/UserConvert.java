package ru.job4j.tracker;

import java.util.HashMap;
import java.util.List;

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
