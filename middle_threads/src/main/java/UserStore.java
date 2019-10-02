import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.ArrayList;
import java.util.List;

@ThreadSafe
public class UserStore<E> {
    @GuardedBy("this")
    private List<User> listUsers = new ArrayList<>();

    public synchronized User getUserForIdex(int index) {
        return listUsers.get(index);
    }

    public synchronized boolean add(User user) {
        return listUsers.add(user);
    }

    public synchronized boolean update(User user, int amount) {
        boolean result = false;
        try {
            listUsers.get(listUsers.indexOf(user)).setAmount(amount);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public synchronized boolean delete(User user) {
        return listUsers.remove(user);
    }

    public synchronized boolean transfer(int fromId, int toId, int amount) {
        boolean result = false;
        User fromUser = findById(fromId);
        User toUser = findById(toId);
        if (fromUser.getAmount() >= amount) {
            int fromAmount = fromUser.getAmount() - amount;
            int toAmount = toUser.getAmount() + amount;
            update(fromUser, fromAmount);
            update(toUser, toAmount);
            result = true;
        }
        return result;
    }

    private synchronized User findById(int id) {
        User findedUser = null;
        for (User user: this.listUsers) {
            if (user.getId() == id) {
                findedUser = user;
            }
        }
        return findedUser;
    }
}
