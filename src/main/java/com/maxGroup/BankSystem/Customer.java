package com.maxGroup.BankSystem;

import com.maxGroup.BankSystem.AccountFactory.AccFactory;
import com.maxGroup.BankSystem.AccountFactory.IAccount;
import com.maxGroup.BankSystem.AccountFactory.IAccountFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Customer extends Human implements Serializable {
    private static int nextId = 1;
    private int idCustomer;
    private String statusCustomer;
    private ArrayList<IAccount> account = new ArrayList<IAccount>();

    public Customer() {
        setName("none");
        setSurname("none");
        setBorn(new GregorianCalendar(1970, 1, 1));
        this.statusCustomer = "usual";
        setIdCustomer();
        createAccount();
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
        createAccount(balance, pass);
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
    public boolean createAccount(int balance, int pass) {
        Scanner in = new Scanner(System.in);
        System.out.println("Do you want create account for?(credit,deposit,payments - enter your answer)");
        String choices = in.nextLine();
        IAccountFactory factory = AccFactory.createAccountFactory(choices);
        return account.add(factory.createAccount(balance, pass));
    }

    public boolean createAccount() {
        Scanner in = new Scanner(System.in);
        System.out.println("Do you want create account for?(credit, deposit, payments - enter your answer)");
        String choices = in.nextLine();
        IAccountFactory factory = AccFactory.createAccountFactory(choices);
        return account.add(factory.createAccount());
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
        for (IAccount item : account) {
            if (item.getCardNumber() == accountId) {
                if (item.getBalance() > 0) {
                    do {
                        System.out.println("You have many at the account, enter number account when you wont transfer many");
                        accountIdNew = in.nextLine();
                        for (IAccount item2 : account) {
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
        for (IAccount item : account) sum += item.getBalance();
        return sum;
    }

    public String getAccountNumbers() {
        String numbers = "";
        for (IAccount item : account) numbers += item.getCardNumber() + "  ";
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