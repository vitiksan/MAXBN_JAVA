package com.maxGroup.BankSystem.domain;

import com.maxGroup.BankSystem.DAO.DAOexception;
import com.maxGroup.BankSystem.DAO.IGenDao;
import com.maxGroup.BankSystem.DAO.Identificator;
import com.maxGroup.BankSystem.mysql.MySqlDaoFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends Human implements Serializable, Identificator<Integer> {
    private int idCustomer;
    private String statusCustomer;
    private ArrayList<Account> accounts = new ArrayList<Account>();

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
        return accounts;
    }

    /**
     * Створення нового аккаунта
     *
     * @param balance - Баланс нового рахунку
     * @param pass    - Пароль нового рахунку
     * @return - true якщо операція виконана, false якщо ні
     */
    public boolean createAccount(int balance, int pass, String type) {
        return accounts.add(new Account(balance, pass, type));
    }

    public boolean createAccount() {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Enter opening balance:");
            double balance = Double.parseDouble(in.next());
            System.out.println("Enter type account(for payments, credit, deposit):");
            String type = in.nextLine();
            System.out.println("Enter password:");
            int password = Integer.parseInt(in.next());
            System.out.println("Repeat password:");
            int repeatPassword = Integer.parseInt(in.next());
            if (password != repeatPassword) throw new Exception("Password and repeat password do`nt match");
            Account account = new Account(balance, password, type);

            MySqlDaoFactory factory = new MySqlDaoFactory();
            IGenDao dao = factory.getDAO(factory.getConnection(), Account.class);

            account = (Account) dao.createEx(account);
            if (account != null) {
                accounts.add(account);
                return true;
            }
        } catch (DAOexception daOexception) {
            daOexception.getMessage();
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }

    public boolean deleteAccount() {
        Scanner in = new Scanner(System.in);
        int accountId;
        int accountIdNew;
        boolean search = false;
        System.out.println("Enter id accounts, that you want to close:");
        try {
            accountId = Integer.parseInt(in.next());
            for (Account item : accounts) {
                if (item.getId() == accountId) {
                    if (item.getBalance() > 0) {
                        do {
                            System.out.println("You have many at the accounts, enter id accounts when you want transfer many");
                            accountIdNew = Integer.parseInt(in.next());
                            for (Account item2 : accounts) {
                                if (item2.getId() == accountIdNew) {
                                    search = true;
                                    item2.fillBalance(item.getBalance());
                                    MySqlDaoFactory factory = new MySqlDaoFactory();
                                    IGenDao dao = factory.getDAO(factory.getConnection(), Account.class);
                                    dao.delete(item);
                                    accounts.remove(item);
                                    return true;
                                }
                            }
                        } while (!search);
                    } else accounts.remove(item);
                }
            }
        } catch (DAOexception e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getBalanceAccounts() {
        int sum = 0;
        for (Account item : accounts) sum += item.getBalance();
        return sum;
    }

    public String getAccountNumbers() {
        String numbers = "";
        for (Account item : accounts) numbers += item.getCardNumber() + "  ";
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