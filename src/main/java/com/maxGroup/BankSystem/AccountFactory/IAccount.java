package com.maxGroup.BankSystem.AccountFactory;

public interface IAccount {
    String getCardNumber();
    void setCardNumber(String numberAccount);
    double getBalance();
    void setBalance(double balance);
    void setPass(int pass);
    int getPass();
    void setExpCard();
    String generateVCNumber();
    boolean checkPassword();
    Boolean getMany(double count);
    Boolean fillBalance(double count);
    void GetExp();
    void setAccountId();
    void setAccountId(int id);
    int getAccountId();
    String getType();
}
