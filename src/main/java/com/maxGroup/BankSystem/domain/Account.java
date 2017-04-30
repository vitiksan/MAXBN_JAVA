package com.maxGroup.BankSystem.domain;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Scanner;

public class Account implements Serializable {
    private static int nextId = 1;
    private int id;
    private String cardNumber;
    private double balance;
    private int pass;
    private String type;    //dor payments, for deposit, for credit
    private GregorianCalendar expCard;

    public Account() {
        cardNumber = generateVCNumber();
        balance = 0;
        pass = 1111;
        type = "for payments";
        setExpCard();
        setId();
    }

    /**
     * Конструктор
     * @param balance - Кількість грошей на рахунку
     * @param pass - Пароль від рахунку
     * @param type - Тип аккаунту
     */
    public Account(double balance, int pass,String type) {
        cardNumber = generateVCNumber();
        this.balance = balance;
        this.pass = pass;
        this.type=type;
        setExpCard();
        setId();
    }

    public Account(double balance, int pass,String cardNumber, String type) {
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.pass = pass;
        this.type = type;
        setExpCard();
        setId();
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String numberAccount) {
        this.cardNumber = numberAccount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public void setExpCard() {
        GregorianCalendar now = new GregorianCalendar();
        expCard = new GregorianCalendar(now.get(GregorianCalendar.YEAR) + 4, now.get(GregorianCalendar.MONTH), now.get(GregorianCalendar.DATE));
    }

    /**
     *
     * @return - генерація 16-значного номера рахунку
     */
    public String generateVCNumber() {
        String temp = "4";
        Random random = new Random(0);
        for (int i = 0; i < 15; i++) {
            temp += String.valueOf(random.nextInt(10));
        }
        return temp;
    }

    public boolean checkPassword() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter password: ");
        if (in.nextInt() == pass) return true;
        else return false;
    }

    /**
     * Зняття грошей з рахунку
     * @param count - Сума, яку потрібно зняти з рахунку
     * @return - true якщо операція виконана, false якщо ні
     */
    public Boolean getMany(double count) {
        if (checkPassword() && count <= this.balance) {
            this.balance -= count;
            return true;
        }
        return false;
    }

    /**
     * Поповнення рахунку
     * @param count - Сума, на яку поповнюється рахунок
     * @return - true якщо операція виконана, false якщо ні
     */
    public Boolean fillBalance(double count) {
        if (count > 0) {
            balance += count;
            return true;
        }
        return false;
    }

    public void GetExp() {
        GregorianCalendar now = new GregorianCalendar();
        int yearNow = now.get(GregorianCalendar.YEAR);
        int yearExpCard = expCard.get(GregorianCalendar.YEAR);
        int monthNow = now.get(GregorianCalendar.MONTH);
        int monthExpCard = expCard.get(GregorianCalendar.MONTH);
        if (yearNow > yearExpCard || (yearNow == yearExpCard && monthNow > monthExpCard))
            System.out.println("Your card will be closed less as 2 month ago");
    }

    public int getId() {
        return id;
    }

    public void setId() {
        id = nextId;
        nextId++;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public int getPass() {
        return pass;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static void setNextId(int nextId) {
        Account.nextId = nextId;
    }
}