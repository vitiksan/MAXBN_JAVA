package com.maxGroup.BankSystem;


public class Officer extends Employee {
    private String levelOfGovernment;

    public Officer() {
        super();
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
        super(name, surname, post, year, month, day, salary, yearStart, monthStart, dayStart);
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
        super(name, surname, post, year, month, day, salary);
        this.levelOfGovernment = levelOfGovernment;
    }

    public String getLevelOfGovernment() {
        return levelOfGovernment;
    }

    public void setLevelOfGovernment(String levelOfGovernment) {
        this.levelOfGovernment = levelOfGovernment;
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