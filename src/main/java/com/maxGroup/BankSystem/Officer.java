package com.maxGroup.BankSystem;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Officer extends Employee implements Serializable {
    private ArrayList<Manager> subordinates;

    public Officer() {
        setName("none");
        setSurname("none");
        setBorn(new GregorianCalendar());
        setPost("none");
        setStartWork(new GregorianCalendar());
        setSalary(3000);
        subordinates = new ArrayList<Manager>();
    }

    /**
     * @param name       - Ім'я
     * @param surname    - Прізвище
     * @param post       - Посада працівника
     * @param year       - Рік народження
     * @param month      - Місяць народженя
     * @param day        - День народження
     * @param salary     - Зарплата
     * @param yearStart  - Рік початку роботи
     * @param monthStart - Місяць початку роботи
     * @param dayStart   - День початку роботи
     */
    public Officer(String name, String surname, String post, int year, int month, int day, int salary, int yearStart, int monthStart, int dayStart) {
        setName(name);
        setSurname(surname);
        setPost(post);
        setBorn(new GregorianCalendar(year, month, day));
        setSalary(salary);
        setStartWork(new GregorianCalendar(yearStart, monthStart, dayStart));
        subordinates = new ArrayList<Manager>();
    }

    /**
     * Конструктор
     *
     * @param name    - Ім'я
     * @param surname - Прізвище
     * @param post    - Посада працівника
     * @param year    - Рік народження
     * @param month   - Місяць народженя
     * @param day     - День народження
     * @param salary  - Зарплата
     */
    public Officer(String name, String surname, String post, int year, int month, int day, int salary) {
        setName(name);
        setSurname(surname);
        setPost(post);
        setBorn(new GregorianCalendar(year, month, day));
        setSalary(salary);
        subordinates = new ArrayList<Manager>();
    }


    public void setBonus() {
        setSalary(getSalary() * 1.1);
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
                + ", subordinates = " + ""
                + "]";
    }
}