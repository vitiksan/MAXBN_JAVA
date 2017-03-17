package com.maxGroup.BankSystem;


import java.util.GregorianCalendar;

public class Consulter extends Employee {
    private String occupation;

    public Consulter() {
        setName("none");
        setSurname("none");
        setBorn(new GregorianCalendar());
        setPost("none");
        setStartWork(new GregorianCalendar());
        setSalary(3000);
        occupation = "Credit";
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
     * @param occupation - Обсласть в якій працівник проводить консультації
     * @param yearStart - Рік початку роботи
     * @param monthStart - Місяць початку роботи
     * @param dayStart - День початку роботи
     */
    public Consulter(String name, String surname, String post, int year, int month, int day, int salary, String occupation, int yearStart, int monthStart, int dayStart) {
        setName(name);
        setSurname(surname);
        setBorn(new GregorianCalendar(year,month,day));
        setPost(post);
        setStartWork(new GregorianCalendar(yearStart,monthStart,dayStart));
        setSalary(salary);
        this.occupation = occupation;
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
     * @param occupation - Обсласть в якій працівник проводить консультації
     */
    public Consulter(String name, String surname, String post, int year, int month, int day, int salary, String occupation) {
        setName(name);
        setSurname(surname);
        setBorn(new GregorianCalendar(year,month,day));
        setPost(post);
        setSalary(salary);
        this.occupation = occupation;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setBonus() {
        setSalary(getSalary() * 1.20);
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
                + ", occupation = " + occupation
                + "]";
    }
}