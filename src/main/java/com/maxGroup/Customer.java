package com.maxGroup;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends Human {
    private static int nextId = 1;
    private int idCustomer;
    private String statusCustomer; //gold, platinum or usual
    private ArrayList<Account> account = new ArrayList<Account>();

    public Customer() {
        super();
        this.statusCustomer = "usual";
        setIdCustomer();
        account.add(new Account());
    }

    public Customer(String statusCustomer, String name, String surname, int year, int month, int day, int balance, int pass) {
        super(name, surname, year, month, day);
        setIdCustomer();
        this.statusCustomer = statusCustomer;
        account.add(new Account(balance, pass));
    }


    @Override
    public String toString() {
        return getClass().getName() +
                "[ name = " + getName()
                + ", surname = " + getSurname()
                + ", old = " + getOld()
                + ", IdCustomer = " + idCustomer
                + ", Status Customer = " + statusCustomer
                + ", number Accounts = " + getAccountNumbers()
                + ", general balance = " + getBalanceAccounts()
                + "]";
    }

    public boolean deleteAccount() {
        Scanner in = new Scanner(System.in);
        String accountId;
        String accountIdNew;
        boolean search = false;
        System.out.println("Enter number account, that you want to close:");
        accountId = in.nextLine();
        for (Account item : account) {
            if (item.getCardNumber() == accountId) {
                if (item.getBalance() > 0) {
                    do {
                        System.out.println("You have many at the account, enter number account when you wont transfer many");
                        accountIdNew = in.nextLine();
                        for (Account item2 : account) {
                            if (item2.getCardNumber() == accountIdNew) {
                                search = true;
                                item2.fillBalance(item.getBalance());
                                account.remove(item);
                                return true;
                            }
                        }
                    } while (!search);
                } else account.remove(item);
            }
        }
        return false;
    }

    public Boolean createAccount(int balance, int pass) {
        return account.add(new Account(balance, pass));
    }

    public void setIdCustomer() {
        this.idCustomer = nextId;
        nextId++;
    }

    public int getBalanceAccounts() {
        int sum = 0;
        for (Account item : account) sum += item.getBalance();
        return sum;
    }

    public String getAccountNumbers() {
        String numbers = "";
        for (Account item : account) numbers += item.getCardNumber() + "  ";
        return numbers;
    }

    public String getStatusCustomer() {
        return statusCustomer;
    }

    public void setStatusCustomer(String statusCustomer) {
        this.statusCustomer = statusCustomer;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public static int getNextId() {
        return nextId;
    }
}