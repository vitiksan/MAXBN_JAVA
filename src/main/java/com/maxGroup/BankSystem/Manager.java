package com.maxGroup.BankSystem;


import java.io.Serializable;
import java.util.GregorianCalendar;

public class Manager extends Employee implements Serializable {
    private int countClient;

    public Manager() {
        setName("none");
        setSurname("none");
        setBorn(new GregorianCalendar());
        setPost("none");
        setStartWork(new GregorianCalendar());
        setSalary(3000);
        countClient = 0;
    }

    /**
     * Конструктор
     * @param name - Ім'я
     * @param surname - Прізвище
     * @param post - Посада працівника
     * @param year - Рік народження
     * @param month - Місяць народженя
     * @param day - День народження
     * @param salary - Зарплата
     * @param countClient - Кількість клієнтів, яку обслуговує цей менеджер
     * @param yearStart - Рік початку роботи
     * @param monthStart - Місяць початку роботи
     * @param dayStart - День початку роботи
     */
    public Manager(String name, String surname, String post, int year, int month, int day, int salary, int countClient, int yearStart, int monthStart, int dayStart) {
        setName(name);
        setSurname(surname);
        setPost(post);
        setBorn(new GregorianCalendar(year,month,day));
        setSalary(salary);
        this.countClient = countClient;
        setStartWork(new GregorianCalendar(yearStart,monthStart,dayStart));
    }

    /**
     * Конструктор
     * @param name - Ім'я
     * @param surname - Прізвище
     * @param post - Посада працівника
     * @param year - Рік народження
     * @param month - Місяць народженя
     * @param day - День народження
     * @param salary - Зарплата
     * @param countClient - Кількість клієнтів, яку обслуговує цей менеджер
     */
    public Manager(String name, String surname, String post, int year, int month, int day, int salary, int countClient) {
        setName(name);
        setSurname(surname);
        setPost(post);
        setBorn(new GregorianCalendar(year,month,day));
        setSalary(salary);
        this.countClient = countClient;
    }

    public int getCountClient() {
        return countClient;
    }

    public void setCountClient(int countClient) {
        this.countClient = countClient;
    }

    public void setBonus() {
        setSalary(getSalary() * 1.25);
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
}