package com.maxGroup.BankSystem.AccountFactory;

public interface IAccount {
    public String getCardNumber();
    public void setCardNumber(String numberAccount);
    public int getBalance();
    public void setBalance(int balance);
    public void setPass(int pass);
    public void setExpCard();
    public String generateVCNumber();
    public boolean checkPassword();
    public Boolean getMany(int count);
    public Boolean fillBalance(int count);
    public void GetExp();
}
