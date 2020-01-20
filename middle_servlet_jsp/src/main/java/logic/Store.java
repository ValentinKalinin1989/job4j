package logic;

import model.User;

import java.util.List;

public interface Store {
    boolean add(User user);

    boolean update(User user);

    boolean delete(int id);

    List<User> findAll();

    User findById(int id);

    User isCredentional(String login, String password);

    List<String> getCountries();

    List<String> getTowns(String country);
}
