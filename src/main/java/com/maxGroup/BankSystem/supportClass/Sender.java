package com.maxGroup.BankSystem.supportClass;

import com.maxGroup.BankSystem.domain.Transaction;

public class Sender extends UsersFromTransaction {

    @Override
    public int getId(Transaction transaction) {
        return transaction.getAccountIdFrom();
    }
}
