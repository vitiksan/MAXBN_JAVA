package com.maxGroup.AccountFactory;

public class AccForPaymentsFactory implements IAccountFactory {
    public IAccount createAccount() {
        return new AccForPayments();
    }

    public IAccount createAccount(double balance, int pass) {
        return new AccForPayments(balance, pass);
    }

    public IAccount createAccount(double balance, int pass, String cardNumber) {
        return new AccForPayments(balance, pass, cardNumber);
    }
}
