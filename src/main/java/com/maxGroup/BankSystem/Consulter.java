package com.maxGroup.BankSystem;


public class Consulter extends Employee {
    private String occupation;

    public Consulter() {
        super();
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
        super(name, surname, post, year, month, day, salary, yearStart, monthStart, dayStart);
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
        super(name, surname, post, year, month, day, salary);
        this.occupation = occupation;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
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