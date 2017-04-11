package com.maxGroup.BankSystem.AccountFactory;

public class AccForDepositFactory implements IAccountFactory {
    public IAccount createAccount() {
        return new AccForDeposit();
    }

    public IAccount createAccount(int balance, int pass) {
        return new AccForDeposit(balance,pass);
    }
}
