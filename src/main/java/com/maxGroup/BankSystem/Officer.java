package com.maxGroup.BankSystem;


import java.io.Serializable;
import java.util.GregorianCalendar;

public class Officer extends Employee implements Serializable {
    private String levelOfGovernment;

    public Officer() {
        setName("none");
        setSurname("none");
        setBorn(new GregorianCalendar());
        setPost("none");
        setStartWork(new GregorianCalendar());
        setSalary(3000);
        levelOfGovernment = "";
    }

    /**
     *
     * @param name - Ім'я
     * @param surname - Прізвище
     * @param post - Посада працівника
     * @param year - Рік народження
     * @param month - Місяць народженя
     * @param day - День народження
     * @param salary - Зарплата
     * @param levelOfGovernment - Рівень доступу(можливості керування або доступу до рахунків)
     * @param yearStart - Рік початку роботи
     * @param monthStart - Місяць початку роботи
     * @param dayStart - День початку роботи
     */
    public Officer(String name, String surname, String post, int year, int month, int day, int salary, String levelOfGovernment, int yearStart, int monthStart, int dayStart) {
        setName(name);
        setSurname(surname);
        setPost(post);
        setBorn(new GregorianCalendar(year,month,day));
        setSalary(salary);
        setStartWork(new GregorianCalendar(yearStart,monthStart,dayStart));
        this.levelOfGovernment = levelOfGovernment;
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
     * @param levelOfGovernment - Рівень доступу(можливості керування або доступу до рахунків)
     */
    public Officer(String name, String surname, String post, int year, int month, int day, int salary, String levelOfGovernment) {
        setName(name);
        setSurname(surname);
        setPost(post);
        setBorn(new GregorianCalendar(year,month,day));
        setSalary(salary);
        this.levelOfGovernment = levelOfGovernment;
    }

    public String getLevelOfGovernment() {
        return levelOfGovernment;
    }

    public void setLevelOfGovernment(String levelOfGovernment) {
        this.levelOfGovernment = levelOfGovernment;
    }

    public void setBonus() {
        setSalary(getSalary() * 1.1);
        Serializator serializator = new Serializator();
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "[ name = " + getName()
                + ", surname = " + getSurname()
                + ", old = " + getOld()
                + ", post = " + getPost()
                + ", experience = " + getExperience()
                + " month, salary = " + getSalary()
                + ", level of government = " + levelOfGovernment
                + "]";
    }
}