package com.maxGroup;

import java.util.ArrayList;

public class Customer extends Human {
    private static int nextId=1;
    private int idCustomer;
    private String statusCustomer; //gold, platinum or usual
    private ArrayList<Account> account= new ArrayList<Account>();

    public Customer() {
        super();
        this.statusCustomer = "usual";
        setIdCustomer();
        account.add(new Account());
    }

    public Customer(String statusCustomer, String name, String surname, int year, int month, int day, String numberAccount, int balance, int pass) {
        super(name, surname, year, month, day);
        setIdCustomer();
        this.statusCustomer = statusCustomer;
        account.add(new Account(numberAccount, balance, pass));
    }
    public Boolean createAccount(int balance, int pass){
        return account.add(new Account(balance, pass));
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "[ name = " + getName()
                + ", surname = " + getSurname()
                + ", date born = " + getBorn().getGregorianChange()
                + ", IdCustomer = " + idCustomer
                + ", Status Customer = " + statusCustomer
                //+ ", number Accounts = " +
                //for(Account it: account) it.getNumberAccount();
                //+ ", balance = " + account.getBalans()
                + "]";
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

    public void setIdCustomer() {
        this.idCustomer = nextId;
        nextId++;
    }
    public static int getNextId(){
        return nextId;
    }
}
