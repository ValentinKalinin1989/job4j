package ru.job4j.bank;

import java.math.BigDecimal;

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
}
