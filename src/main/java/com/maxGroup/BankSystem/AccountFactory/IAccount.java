package com.maxGroup.BankSystem.AccountFactory;

public interface IAccount {
    String getCardNumber();
    void setCardNumber(String numberAccount);
    int getBalance();
    void setBalance(int balance);
    void setPass(int pass);
    void setExpCard();
    String generateVCNumber();
    boolean checkPassword();
    Boolean getMany(int count);
    Boolean fillBalance(int count);
    void GetExp();
    void setAccountId();
    int getAccountId();
}
