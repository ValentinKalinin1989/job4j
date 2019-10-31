package logic;

import model.User;

import java.time.LocalDate;
import java.util.concurrent.CopyOnWriteArrayList;

public class UsersRepositoryMemory implements Store {
    private CopyOnWriteArrayList<User> userList;

    private UsersRepositoryMemory() {
        this.userList = new CopyOnWriteArrayList<>();
        this.userList.add(new User(1, "Feday", "Assasin", "f_1990@yandex.ru", LocalDate.of(1990, 12, 31)));
        this.userList.add(new User(2, "Sanay", "Killer", "rty_1990@yandex.ru", LocalDate.of(1967, 12, 31)));
        this.userList.add(new User(3, "Vova", "Gamer", "jol_1990@yandex.ru", LocalDate.of(1954, 12, 31)));
        this.userList.add(new User(4, "Kolay", "WhyWhat", "toy_1990@yandex.ru", LocalDate.of(1955, 12, 31)));
        this.userList.add(new User(5, "Vanay", "Edfrwse", "free_1990@yandex.ru", LocalDate.of(1988, 12, 31)));
    }

    private static final class Holder {
        private static final UsersRepositoryMemory INSTANCE = new UsersRepositoryMemory();
    }

    public static UsersRepositoryMemory getInstance() {
        return Holder.INSTANCE;
    }

    @Override
    public boolean add(User user) {
        return this.userList.add(user);
    }

    @Override
    public boolean update(User user) {
        boolean result = false;
        User userFinded = findById(user.getId());
        if (userFinded != null) {
            userFinded.setName(user.getName());
            userFinded.setLogin(user.getLogin());
            userFinded.setEmail(user.getEmail());
            userFinded.setCreateDate(user.getCreateDate());
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        User userFinded = findById(id);
        if (userFinded != null) {
            this.userList.remove(userFinded);
            result = true;
        }
        return result;
    }

    @Override
    public CopyOnWriteArrayList<User> findAll() {
        return this.userList;
    }

    @Override
    public User findById(int id) {
        User userResult = null;
        for (User user: this.userList) {
            if (user.getId() == id) {
                userResult = user;
            }
        }
        return userResult;
    }
}
