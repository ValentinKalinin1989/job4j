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
            this.usersTree.entrySet().stream()
                    .filter(e -> e.getKey().getPassport().equals(passport))
                    .findFirst()
                    .map(Map.Entry::getValue)
                    .orElse(null).add(account);
    }

    public List<Account> getUserAccounts(String passport) {
        return this.usersTree.entrySet().stream()
                .filter(e -> e.getKey().getPassport().equals(passport))
                .findFirst()
                .map(Map.Entry::getValue).orElse(null);
    }

    public Account getUserAccountForRequisite(String userPassport, String userRequisite) {
        return this.usersTree.entrySet().stream()
                .filter(e -> e.getKey().getPassport().equals(userPassport))
                .findFirst()
                .map(Map.Entry::getValue)
                .orElse(new ArrayList<>())
                .stream()
                .filter(e -> e.getRequisites().equals(userRequisite)).findFirst().orElse(null);
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

        srcAccount.transferAmount(dstAccount, amount);

        return true;
    }

    public TreeMap<User, ArrayList<Account>> getUsersTree() {
        return usersTree;
    }
}
