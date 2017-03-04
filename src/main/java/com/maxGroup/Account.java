package com.maxGroup;


public class Account {
    private String numberAccount;
    private int balance;
    private int pass;

    public Account(){
        this.numberAccount = "0000000000";
        this.balance = 0;
        this.pass=11111111;
    }
    public Account(String numberAccount, int balance, int pass){
        this.numberAccount=numberAccount;
        this.balance=balance;
        this.pass=pass;
    }

    public void fillBalans(int count){
        balance+=count;
    }
    public Boolean GetMany(int count, int pass){
        if(pass==this.pass && count <=this.balance)
        {
            this.balance-=count;
            return true;
        }
        return false;
    }
    public String getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    public int getBalans() {
        return balance;
    }

    public void setBalans(int balance) {
        this.balance = balance;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }
}
