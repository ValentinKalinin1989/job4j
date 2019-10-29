package logic;

import model.User;

import java.util.concurrent.ConcurrentSkipListSet;

public interface Store {
    boolean add(User user);
    boolean update(User user);
    boolean delete(int id);
    ConcurrentSkipListSet<User> findAll();
    User findById(int id);
}
