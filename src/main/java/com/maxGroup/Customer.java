package com.maxGroup;

public class Customer extends Human {
    private String statusCustomer; //gold, platinum or usual
    private int countCard;
    private int countCredit;
    private int countDeposit;
    private String idCustomer;


    public Customer() {
        statusCustomer = "usual";
        countCard = 0;
        countDeposit = 0;
        countDeposit = 0;
        idCustomer = "0000000";
    }

    public Customer(String statusCustomer, String idCustomer, String name, String surname, int old, int countCard, int countCredit, int countDeposit) {
        setName(name);
        setSurname(surname);
        setStatusCustomer(statusCustomer);
        setIdCustomer(idCustomer);
        setOld(old);
        setCountCard(countCard);
        setCountCredit(countCredit);
        setCountDeposit(countDeposit);
    }
    @Override
    public String toString() {
        System.out.println("Name: " + getName());
        System.out.println("Surname: " + getSurname());
        System.out.println("Old: " + getOld());
        System.out.println("Status customer: " + statusCustomer);
        System.out.println("ID customer: " + idCustomer);
        System.out.println("Count card: " + countCard);
        System.out.println("Count credit: " + countCredit);
        System.out.println("Count deposit: " + countDeposit);
        return null;
    }

    public String getStatusCustomer() {
        return statusCustomer;
    }

    public void setStatusCustomer(String statusCustomer) {
        this.statusCustomer = statusCustomer;
    }

    public int getCountCard() {
        return countCard;
    }

    public void setCountCard(int countCard) {
        this.countCard = countCard;
    }

    public int getCountCredit() {
        return countCredit;
    }

    public void setCountCredit(int countCredit) {
        this.countCredit = countCredit;
    }

    public int getCountDeposit() {
        return countDeposit;
    }

    public void setCountDeposit(int countDeposit) {
        this.countDeposit = countDeposit;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }
}
