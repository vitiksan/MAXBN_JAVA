package com.maxGroup.BankSystem.domain;

import com.maxGroup.BankSystem.DAO.Identificator;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Scanner;

public class Account implements Identificator<Integer> {
    private int id;
    private String cardNumber;
    private double balance;
    private int pass;
    private String type;
    private GregorianCalendar expCard;

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String numberAccount) {
        this.cardNumber = numberAccount;
    }

    /**
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Зняття грошей з рахунку
     *
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
     *
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

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public boolean checkPassword() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter password: ");
        if (in.nextInt() == pass) return true;
        else return false;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setExpCard() {
        GregorianCalendar now = new GregorianCalendar();
        expCard = new GregorianCalendar(now.get(GregorianCalendar.YEAR) + 4, now.get(GregorianCalendar.MONTH), now.get(GregorianCalendar.DATE));
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

}
