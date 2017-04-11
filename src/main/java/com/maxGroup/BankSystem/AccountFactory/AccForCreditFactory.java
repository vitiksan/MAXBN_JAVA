package com.maxGroup.BankSystem.AccountFactory;

public class AccForCreditFactory implements IAccountFactory {
    public IAccount createAccount() {
        return new AccForCredit();
    }

    public IAccount createAccount(int balance, int pass) {
        return new AccForCredit(balance,pass);
    }
}
