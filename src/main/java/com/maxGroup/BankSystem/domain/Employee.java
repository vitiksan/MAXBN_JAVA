package com.maxGroup.BankSystem.domain;


import org.apache.log4j.Logger;

import java.util.GregorianCalendar;

public abstract class Employee extends Human {
    private static final Logger log = Logger.getLogger(Employee.class);
    private String post;
    private GregorianCalendar startWork;
    private double salary;

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

    /**
     * Підняття зарплати
     *
     * @param count - Сума, на яку потрібно підняти зарплату
     * @return - true якщо операція виконана, false якщо ні
     */
    public Boolean riseSalary(int count) {
        if (count > 0) {
            salary += count;
            return true;
        }
        return false;
    }

    /**
     * Урізання зарплати
     *
     * @param count - Сума, на яку потрібно опустити зарплату
     * @return - true якщо операція виконана, false якщо ні
     */
    public Boolean reduceSalary(int count) {
        if (count > 0) {
            salary -= count;
            return true;
        }
        return false;
    }

    /**
     * Вирахування досвіду роботи
     *
     * @return - досвід роботи працівника у місяцях
     */
    public int getExperience() {
        int month = 0;
        GregorianCalendar now = new GregorianCalendar();
        try {
            month = (now.get(GregorianCalendar.YEAR) - startWork.get(GregorianCalendar.YEAR)) * 12;
            month += now.get(GregorianCalendar.MONTH) - startWork.get(GregorianCalendar.MONTH) + 1;
            if (now.get(GregorianCalendar.MONTH) == startWork.get(GregorianCalendar.MONTH)
                    && now.get(GregorianCalendar.DATE) < startWork.get(GregorianCalendar.DATE)) month--;
            now = null;
        } catch (NullPointerException e) {
            System.out.println("Виняток " + e);
            log.error("Виняток " + e);
        }
        return month;
    }

    public abstract void setBonus();
}