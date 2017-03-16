package com.maxGroup.BankSystem;


import java.util.GregorianCalendar;

public class Employee extends Human {
    private String post;
    private GregorianCalendar startWork;
    private double salary;

    public Employee() {
        super();
        post = "none";
        startWork = new GregorianCalendar();
        salary = 3000;
    }

    public Employee(String name, String surname, String post, int year, int month, int day, int salary, int yearStart, int monthStart, int dayStart) {
        super(name, surname, year, month, day);
        startWork = new GregorianCalendar(yearStart, monthStart, dayStart);
        this.post = post;
        this.salary = salary;
    }

    public Employee(String name, String surname, String post, int year, int month, int day, int salary) {
        super(name, surname, year, month, day);
        startWork = new GregorianCalendar();
        this.post = post;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "[ name = " + getName()
                + ", surname = " + getSurname()
                + ", old = " + getOld()
                + ", post = " + post
                + ", experience = " + getExperience()
                + " month, salary = " + salary
                + "]";
    }

    public Boolean riseSalary(int count) {
        if (count > 0) {
            salary += count;
            return true;
        }
        return false;
    }

    public Boolean reduceSalary(int count) {
        if (count > 0) {
            salary -= count;
            return true;
        }
        return false;
    }

    public int getExperience() {
        int month;
        GregorianCalendar now = new GregorianCalendar();
        month = (now.get(GregorianCalendar.YEAR) - startWork.get(GregorianCalendar.YEAR)) * 12;
        month += now.get(GregorianCalendar.MONTH) - startWork.get(GregorianCalendar.MONTH) + 1;
        if (now.get(GregorianCalendar.MONTH) == startWork.get(GregorianCalendar.MONTH)
                && now.get(GregorianCalendar.DATE) < startWork.get(GregorianCalendar.DATE)) month--;
        return month;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public GregorianCalendar getStartWork() {
        return startWork;
    }

    public void setStartWork(GregorianCalendar startWork) {
        this.startWork = startWork;
    }

    public void setBonus() {
        salary *= 1.10;
    }
}