package com.maxGroup.BankSystem.AccountFactory;

public class AccForDepositFactory implements IAccountFactory {
    public IAccount createAccount() {
        return new AccForDeposit();
    }

    public IAccount createAccount(double balance, int pass) {
        return new AccForDeposit(balance, pass);
    }

    public IAccount createAccount(double balance, int pass, String cardNumber) {
        return new AccForDeposit(balance, pass, cardNumber);
    }
}
