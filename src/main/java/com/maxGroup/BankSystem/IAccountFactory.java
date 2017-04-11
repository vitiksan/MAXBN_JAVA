package com.maxGroup.BankSystem;

public interface IAccountFactory {
    public IAccount createAccount();
    public IAccount createAccount(int balance, int pass);
}
