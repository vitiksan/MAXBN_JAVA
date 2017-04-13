package com.maxGroup.BankSystem.AccountFactory;

public interface IAccountFactory {
    IAccount createAccount();
    IAccount createAccount(int balance, int pass);
}
