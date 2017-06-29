package com.maxGroup.BankSystem.domain;

import com.maxGroup.BankSystem.DAO.Identificator;

import java.util.GregorianCalendar;

public class Transaction implements Identificator<Integer> {
    private int id;
    private int accountIdFrom;
    private int accountIdTo;
    private double amount;
    private GregorianCalendar transactionsDate;

    public Transaction() {
    }

    public Transaction(int accountIdFrom, int accountIdTo, double amount) {
        this.accountIdFrom = accountIdFrom;
        this.accountIdTo = accountIdTo;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountIdFrom() {
        return accountIdFrom;
    }

    public void setAccountIdFrom(int accountIdFrom) {
        this.accountIdFrom = accountIdFrom;
    }

    public int getAccountIdTo() {
        return accountIdTo;
    }

    public void setAccountIdTo(int accountIdTo) {
        this.accountIdTo = accountIdTo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public GregorianCalendar getTransactionsDate() {
        return transactionsDate;
    }

    public void setTransactionsDate(GregorianCalendar transactionsDate) {
        this.transactionsDate = transactionsDate;
    }
}
