package com.maxGroup;

public class Customer extends Human {
    private String statusCustomer; //gold, platinum or usual
    private int countCard;
    private int countCredit;
    private int countDeposit;
    private String idCustomer;


    public Customer() {
        super();
        statusCustomer = "usual";
        countCard = 0;
        countDeposit = 0;
        countDeposit = 0;
        idCustomer = "0000000";
    }

    public Customer(String statusCustomer, String idCustomer, String name, String surname, int year, int month, int day, int countCard, int countCredit, int countDeposit) {
        super(name, surname, year, month, day);
        setStatusCustomer(statusCustomer);
        setIdCustomer(idCustomer);
        setCountCard(countCard);
        setCountCredit(countCredit);
        setCountDeposit(countDeposit);
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "[ name = " + getName()
                + ", surname = " + getSurname()
                + ", date born = " + born.getGregorianChange()
                + ", IdCustomer = " + idCustomer
                + ", StatusCustomer = " + statusCustomer
                + "]";

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
