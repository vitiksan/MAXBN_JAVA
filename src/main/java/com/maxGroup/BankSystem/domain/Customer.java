package com.maxGroup.BankSystem.domain;

import com.maxGroup.BankSystem.DAO.Identificator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Customer extends Human implements Serializable, Identificator<Integer> {
    private int idCustomer;
    private String statusCustomer;
    private ArrayList<Account> account = new ArrayList<Account>();

    public int getId() {
        return idCustomer;
    }

    protected void setId(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getStatusCustomer() {
        return statusCustomer;
    }

    public void setStatusCustomer(String statusCustomer) {
        this.statusCustomer = statusCustomer;
    }

    public ArrayList<Account> getAccount() {
        return account;
    }

    /**
     * Створення нового аккаунта
     *
     * @param balance - Баланс нового рахунку
     * @param pass    - Пароль нового рахунку
     * @return - true якщо операція виконана, false якщо ні
     */
    public boolean createAccount(int balance, int pass, String type) {
        return account.add(new Account(balance,pass,type));
    }

    public boolean createAccount() {
        return account.add(new Account());
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
                        System.out.println("You have many at the account, enter number account when you want transfer many");
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

    @Override
    public boolean equals(Object otherObj) {
        if (this == otherObj) return true;

        if (otherObj == null) return false;

        if (getClass() != otherObj.getClass()) return false;

        Customer temp = (Customer) otherObj;

        return getName().equals(temp.getName())
                && getSurname().equals(temp.getSurname());
    }

    @Override
    public int hashCode() {
        return 6 * getName().hashCode() +
                5 * getSurname().hashCode() +
                9 * getBorn().hashCode();
    }
}