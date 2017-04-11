package com.maxGroup.BankSystem.AccountFactory;

public class AccForPaymentsFactory implements IAccountFactory {
    public IAccount createAccount() {
        return new AccForPayments();
    }

    public IAccount createAccount(int balance, int pass) {
        return new AccForPayments(balance,pass);
    }
}
