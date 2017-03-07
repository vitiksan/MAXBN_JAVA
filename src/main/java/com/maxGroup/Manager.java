package com.maxGroup;


public class Manager extends Employee {
    private int countClient;

    public Manager() {
        super();
        this.countClient = 0;
    }

    public Manager(String name, String surname, String post, int year, int month, int day, int experience, int cell, int countClient) {
        super(name, surname, post, year, month, day, experience, cell);
        this.countClient = countClient;
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "[ name = " + getName()
                + ", surname = " + getSurname()
                + ", date born = " + getBorn().getGregorianChange()
                + ", post = " + getPost()
                + ", experience = " + getExperience()
                + ", cell = " + getCell()
                + ", count of client = " + countClient
                + "]";
    }

    public int getCountClient() {
        return countClient;
    }

    public void setCountClient(int countClient) {
        this.countClient = countClient;
    }
}
