package com.maxGroup;

import java.util.Random;
import java.util.Scanner;

public class Account {
    private String cardNumber;
    private int balance;
    private int pass;

    public Account() {
        cardNumber = generateVCNumber();
        balance = 0;
        pass = 11111111;
    }

    public Account(int balance, int pass) {
        cardNumber = generateVCNumber();
        this.balance = balance;
        this.pass = pass;
    }


    public String generateVCNumber() {
        String temp = "4";
        Random random = new Random(0);
        for (int i = 0; i < 15; i++) {
            temp += String.valueOf(random.nextInt(10));
        }
        return temp;
    }

    public Boolean fillBalans(int count) {
        if (count > 0) {
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

    private boolean checkPassword() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter password: ");
        if (in.nextInt() == pass) return true;
        else return false;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String numberAccount) {
        this.cardNumber = numberAccount;
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