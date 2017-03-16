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

    /**
     * Конструктор
     * @param name - Ім'я
     * @param surname - Прізвище
     * @param year - Рік народження
     * @param month - Місяць народженя
     * @param day - День народження
     * @param salary - Зарплата
     * @param yearStart - Рік початку роботи
     * @param monthStart - Місяць початку роботи
     * @param dayStart - День початку роботи
     */
    public Employee(String name, String surname, String post, int year, int month, int day, int salary, int yearStart, int monthStart, int dayStart) {
        super(name, surname, year, month, day);
        startWork = new GregorianCalendar(yearStart, monthStart, dayStart);
        this.post = post;
        this.salary = salary;
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
     */
    public Employee(String name, String surname, String post, int year, int month, int day, int salary) {
        super(name, surname, year, month, day);
        startWork = new GregorianCalendar();
        this.post = post;
        this.salary = salary;
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

    /**
     * Підняття зарплати
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
     * @return - досвід роботи працівника у місяцях
     */
    public int getExperience() {
        int month;
        GregorianCalendar now = new GregorianCalendar();
        month = (now.get(GregorianCalendar.YEAR) - startWork.get(GregorianCalendar.YEAR)) * 12;
        month += now.get(GregorianCalendar.MONTH) - startWork.get(GregorianCalendar.MONTH) + 1;
        if (now.get(GregorianCalendar.MONTH) == startWork.get(GregorianCalendar.MONTH)
                && now.get(GregorianCalendar.DATE) < startWork.get(GregorianCalendar.DATE)) month--;
        return month;
    }

    public void setBonus() {
        salary *= 1.10;
    }
}