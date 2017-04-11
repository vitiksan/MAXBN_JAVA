package com.maxGroup.BankSystem;

public class AccForPaymentsFactory implements IAccountFactory {
    public IAccount createAccount() {
        return new AccForPayments();
    }
}
