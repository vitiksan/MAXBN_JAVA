package com.maxGroup;

import java.util.Scanner;

public class Account {
    private String numberAccount;
    private int balance;
    private int pass;

    public Account() {
        numberAccount = "0000000000";
        balance = 0;
        pass = 11111111;
    }

    public Account(int balance, int pass) {
        this.balance = balance;
        this.pass = pass;
    }

    public Boolean fillBalans(int count) {
        if(count >0) {
            balance += count;
            return true;
        }
        return false;
    }

    public Boolean getMany(int count) {
        if (checkPassword() && count <= this.balance) {
            this.balance -= count;
            return true;
        }
        return false;
    }

    private boolean checkPassword(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter password: ");
        if(in.nextInt()==pass) return true;
        else return false;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }
}
