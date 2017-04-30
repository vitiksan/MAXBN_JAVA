package com.maxGroup.AccountFactory;

public class AccForCreditFactory implements IAccountFactory {
    public IAccount createAccount() {
        return new AccForCredit();
    }

    public IAccount createAccount(double balance, int pass) {
        return new AccForCredit(balance, pass);
    }

    public IAccount createAccount(double balance, int pass, String cardNumber) {
        return new AccForCredit(balance, pass, cardNumber);
    }
}
