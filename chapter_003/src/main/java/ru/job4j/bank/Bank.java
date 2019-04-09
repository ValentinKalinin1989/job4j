package ru.job4j.bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;

public class Bank {
    private TreeMap<User, ArrayList<Account>> usersTree = new TreeMap<>();

    public void addUser(User user) {
        this.usersTree.putIfAbsent(user, new ArrayList<Account>());
    }

    public void deleteUser(User user) {
        this.usersTree.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        this.usersTree.forEach((key, value) -> {
            if (key.getPassport().equals(passport)) {
                value.add(account);
                return;
            }
        });
    }

    public List<Account> getUserAccounts(String passport) {
        List<Account> listAcc = new ArrayList<Account>();
        for (Map.Entry<User, ArrayList<Account>> entry : usersTree.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                listAcc = entry.getValue();
            }
        }
        return listAcc;
    }

    public Account getUserAccountForRequisite(String userPassport, String userRequisite) {
        List<Account> listAcc = getUserAccounts(userPassport);
        int index = -1;
        for (Account account
                : listAcc) {
            if (account.getRequisites().equals(userRequisite)) {
                index = listAcc.indexOf(account);
            }
        }
        if (index == -1) {
            return null; // если у юзера нет такого счета
        }
        return listAcc.get(index);
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                  String destPassport, String dstRequisite,
                                  double amount) {
        Account srcAccount = getUserAccountForRequisite(srcPassport, srcRequisite);
        if (srcAccount.equals(null)) {
            System.out.println("Счет для снятия денег не найден.");
            return false;
        }
        if (srcAccount.getValue().compareTo(new BigDecimal(amount)) < 0) {
            System.out.println("На счете не достаточно средств");
            return false;
        }
        Account dstAccount = getUserAccountForRequisite(destPassport, dstRequisite);
        if (dstAccount.equals(null)) {
            System.out.println("Счет для зачисления денег не найден.");
            return false;
        }

        BigDecimal subStract = srcAccount.getValue().subtract(new BigDecimal(amount));
        BigDecimal sum = dstAccount.getValue().add(new BigDecimal(amount));
        srcAccount.setValue(subStract);
        dstAccount.setValue(sum);
        return true;
    }

    public TreeMap<User, ArrayList<Account>> getUsersTree() {
        return usersTree;
    }
}
