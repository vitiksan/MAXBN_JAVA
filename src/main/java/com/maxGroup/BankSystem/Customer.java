package com.maxGroup.BankSystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Customer extends Human implements Serializable{
    private static int nextId = 1;
    private int idCustomer;
    private String statusCustomer;
    private ArrayList<Account> account = new ArrayList<Account>();

    public Customer() {
        setName("");
        setSurname("");
        setBorn(new GregorianCalendar());
        this.statusCustomer = "usual";
        setIdCustomer();
        //account.add(new Account());
    }

    /**
     * Конструктор
     *
     * @param statusCustomer - Статус клієнта(наприклад звичайний, золотий або платиновий)
     * @param name           - Ім'я
     * @param surname        - Прізвище
     * @param year           - Рік народження
     * @param month          - Місяць народженя
     * @param day            - День народження
     * @param balance        - Кількість грошей на початкувому рахунку
     * @param pass           - Пароль від початкового рахунку
     */
    public Customer(String statusCustomer, String name, String surname, int year, int month, int day, int balance, int pass) {
        setName(name);
        setSurname(surname);
        setBorn(new GregorianCalendar(year, month, day));
        setIdCustomer();
        this.statusCustomer = statusCustomer;
        account.add(new Account(balance, pass));
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

    /**
     * Створення нового аккаунта
     *
     * @param balance - Баланс нового рахунку
     * @param pass    - Пароль нового рахунку
     * @return - true якщо операція виконана, false якщо ні
     */
    public Boolean createAccount(int balance, int pass) {
        return account.add(new Account(balance, pass));
    }

    public void setIdCustomer() {
        this.idCustomer = nextId;
        nextId++;
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
        return 6*getName().hashCode()+
                5* getSurname().hashCode()+
                9* getBorn().hashCode();
    }
}