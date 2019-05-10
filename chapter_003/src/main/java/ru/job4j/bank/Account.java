package ru.job4j.bank;

import java.math.BigDecimal;
import java.util.Objects;

public class Account {
    private BigDecimal value;
    private String requisites;

    public Account(String requisites, BigDecimal value) {
        this.value = value;
        this.requisites = requisites;
    }
    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getRequisites() {
        return requisites;
    }
    /*
    перевод средств с аккаунта this на dstAccount
     */
    public void transferAmount(Account dstAccount, double amount) {
        BigDecimal subStract = this.getValue().subtract(new BigDecimal(amount));
        BigDecimal sum = dstAccount.getValue().add(new BigDecimal(amount));
        this.setValue(subStract);
        dstAccount.setValue(sum);
    }

}
