package com.maxGroup.AccountFactory;

public interface IAccountFactory {
    IAccount createAccount();
    IAccount createAccount(double balance, int pass);
    IAccount createAccount(double balance, int pass,String cardNumber);
}
