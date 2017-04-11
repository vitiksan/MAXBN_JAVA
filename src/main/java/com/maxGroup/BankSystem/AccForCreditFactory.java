package com.maxGroup.BankSystem;

public class AccForCreditFactory implements IAccountFactory{
    public IAccount createAccount() {
        return new AccForCredit();
    }
}
