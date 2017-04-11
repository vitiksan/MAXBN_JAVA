package com.maxGroup.BankSystem;

public class AccForDepositFactory implements IAccountFactory {
    public IAccount createAccount() {
        return new AccForDeposit();
    }
}
