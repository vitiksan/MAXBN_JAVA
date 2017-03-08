package com.maxGroup;


public class Manager extends Employee {
    private int countClient;

    public Manager() {
        super();
        countClient = 0;
    }

    public Manager(String name, String surname, String post, int year, int month, int day,int salary, int countClient,int yearStart, int mountStart, int dayStart) {
        super(name, surname, post, year, month, day, salary,yearStart,mountStart,dayStart);
        this.countClient = countClient;
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "[ name = " + getName()
                + ", surname = " + getSurname()
                + ", old = " + getOld()
                + ", post = " + getPost()
                + ", experience = " + getExperience()
                + " month, cell = " + getSalary()
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