package com.maxGroup.BankSystem;


public class Manager extends Employee {
    private int countClient;

    public Manager() {
        super();
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
        super(name, surname, post, year, month, day, salary, yearStart, monthStart, dayStart);
        this.countClient = countClient;
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
        super(name, surname, post, year, month, day, salary);
        this.countClient = countClient;
    }

    public int getCountClient() {
        return countClient;
    }

    public void setCountClient(int countClient) {
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

    @Override
    public void setBonus() {
        setSalary(getSalary() * 1.25);
    }
}