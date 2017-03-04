package com.maxGroup;

public class Customer extends Human {
    private String idCustomer;
    private String statusCustomer; //gold, platinum or usual
    private int countCard;
    private int countCredit;
    private int countDeposit;

    public Customer() {
        super();
        this.statusCustomer = "usual";
        this.idCustomer = "0000000";
    }

    public Customer(String statusCustomer, String idCustomer, String name, String surname, int year, int month, int day, int countCard, int countCredit, int countDeposit) {
        super(name, surname, year, month, day);
        this.setIdCustomer(idCustomer);
        this.statusCustomer=statusCustomer;
        setCountCard(countCard);
        setCountCredit(countCredit);
        setCountDeposit(countDeposit);
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "[ name = " + getName()
                + ", surname = " + getSurname()
                + ", date born = " + getBorn().getGregorianChange()
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
