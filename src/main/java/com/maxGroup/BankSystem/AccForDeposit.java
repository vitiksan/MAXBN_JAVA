package com.maxGroup.BankSystem;

import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Scanner;

public class AccForDeposit implements IAccount {
    private String cardNumber;
    private int balance;
    private int pass;
    private GregorianCalendar expCard;

    public AccForDeposit() {
        cardNumber = generateVCNumber();
        balance = 0;
        pass = 1111;
        setExpCard();
    }

    /**
     * Конструктор
     * @param balance - Кількість грошей на рахунку
     * @param pass - Пароль від рахунку
     */
    public AccForDeposit(int balance, int pass) {
        cardNumber = generateVCNumber();
        this.balance = balance;
        this.pass = pass;
        setExpCard();
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
    public Boolean getMany(int count) {
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
    public Boolean fillBalance(int count) {
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
}
