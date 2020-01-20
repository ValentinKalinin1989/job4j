package ru.job4j.bank;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankTest {
    @Test
    public void whenTestTRansferMoney() {
        Bank bank = new Bank();
        bank.addUser(new User("Mels", "4569 7879"));
        bank.addUser(new User("Vell", "6765 8799"));
        bank.addUser(new User("Petr", "7890 0798"));

        bank.addAccountToUser("4569 7879", new Account("2123442", new BigDecimal("12000")));
        bank.addAccountToUser("4569 7879", new Account("2123742", new BigDecimal("18000")));
        bank.addAccountToUser("4569 7879", new Account("5623442", new BigDecimal("6000")));

        bank.addAccountToUser("6765 8799", new Account("267742", new BigDecimal("16000")));
        bank.addAccountToUser("6765 8799", new Account("5623442", new BigDecimal("4000")));

        bank.addAccountToUser("7890 0798", new Account("216742", new BigDecimal("3000")));
        bank.addAccountToUser("7890 0798", new Account("5689442", new BigDecimal("7800")));

        bank.transferMoney("7890 0798", "5689442", "4569 7879", "2123442", 7799);

        BigDecimal resSubstract = bank.getUsersTree().get(new User("Petr", "7890 0798")).get(1).getValue();
        BigDecimal resAdd = bank.getUsersTree().get(new User("Mels", "4569 7879")).get(0).getValue();

        assertThat(resSubstract, is(new BigDecimal(1)));
        assertThat(resAdd, is(new BigDecimal(19799)));
    }
}

