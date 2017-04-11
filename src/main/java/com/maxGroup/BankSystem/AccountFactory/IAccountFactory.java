package com.maxGroup.BankSystem.AccountFactory;

public interface IAccountFactory {
    public IAccount createAccount();
    public IAccount createAccount(int balance, int pass);
}
