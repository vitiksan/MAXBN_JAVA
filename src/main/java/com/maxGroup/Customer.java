package com.maxGroup;

public class Customer extends Human {
    private String idCustomer;
    private String statusCustomer; //gold, platinum or usual
    private Account account;

    public Customer() {
        super();
        this.statusCustomer = "usual";
        this.idCustomer = "0000000";
        account = new Account();
    }

    public Customer(String statusCustomer, String idCustomer, String name, String surname, int year, int month, int day, String numberAccount, int balance, int pass) {
        super(name, surname, year, month, day);
        this.setIdCustomer(idCustomer);
        this.statusCustomer = statusCustomer;
        account = new Account(numberAccount, balance, pass);
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "[ name = " + getName()
                + ", surname = " + getSurname()
                + ", date born = " + getBorn().getGregorianChange()
                + ", IdCustomer = " + idCustomer
                + ", Status Customer = " + statusCustomer
                + ", number Account = " + account.getNumberAccount()
                + ", balance = " + account.getBalans()
                + " UAH ]";
    }

    public String getStatusCustomer() {
        return statusCustomer;
    }

    public void setStatusCustomer(String statusCustomer) {
        this.statusCustomer = statusCustomer;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }
}
