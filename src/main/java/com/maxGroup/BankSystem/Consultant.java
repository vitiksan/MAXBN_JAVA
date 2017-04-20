package com.maxGroup.BankSystem;


import java.io.Serializable;
import java.util.GregorianCalendar;

public class Consultant extends Employee implements Serializable {
    private static int nextId = 1;
    private int idConsultant;
    private String occupation;

    public Consultant() {
        setName("none");
        setSurname("none");
        setBorn(new GregorianCalendar());
        setPost("none");
        setStartWork(new GregorianCalendar());
        setSalary(3000);
        occupation = "Credit";
        setIdConsultant();
    }

    /**
     * Конструктор
     *
     * @param name       - Ім'я
     * @param surname    - Прізвище
     * @param post       - Посада працівника
     * @param year       - Рік народження
     * @param month      - Місяць народженя
     * @param day        - День народження
     * @param salary     - Зарплата
     * @param occupation - Обсласть в якій працівник проводить консультації
     * @param yearStart  - Рік початку роботи
     * @param monthStart - Місяць початку роботи
     * @param dayStart   - День початку роботи
     */
    public Consultant(String name, String surname, String post, int year, int month, int day, int salary, String occupation, int yearStart, int monthStart, int dayStart) {
        setName(name);
        setSurname(surname);
        setBorn(new GregorianCalendar(year, month, day));
        setPost(post);
        setStartWork(new GregorianCalendar(yearStart, monthStart, dayStart));
        setSalary(salary);
        this.occupation = occupation;
        setIdConsultant();
    }

    /**
     * Конструктор
     *
     * @param name       - Ім'я
     * @param surname    - Прізвище
     * @param post       - Посада працівника
     * @param year       - Рік народження
     * @param month      - Місяць народженя
     * @param day        - День народження
     * @param salary     - Зарплата
     * @param occupation - Обсласть в якій працівник проводить консультації
     */
    public Consultant(String name, String surname, String post, int year, int month, int day, int salary, String occupation) {
        setName(name);
        setSurname(surname);
        setBorn(new GregorianCalendar(year, month, day));
        setPost(post);
        setSalary(salary);
        this.occupation = occupation;
        setIdConsultant();
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
                "[ id = " + idConsultant +
                ", name = " + getName()
                + ", surname = " + getSurname()
                + ", old = " + getOld()
                + ", post = " + getPost()
                + ", experience = " + getExperience()
                + " month, salary = " + getSalary()
                + ", occupation = " + occupation
                + "]";
    }

    public int getIdConsultant() {
        return idConsultant;
    }

    public void setIdConsultant() {
        idConsultant = nextId;
        nextId++;
    }
}