package com.maxGroup.BankSystem;


import java.util.GregorianCalendar;

public class Human {
    private String name;
    private String surname;
    private GregorianCalendar born;

    public Human() {
        name = "Name";
        surname = "Surname";
        born = new GregorianCalendar(1970, 01, 01);
    }

    /**
     * Конструктор
     * @param name - Ім'я
     * @param surname - Прізвище
     * @param year - Рік народження
     * @param month - Місяць народженя
     * @param day - День народження
     */

    public Human(String name, String surname, int year, int month, int day) {
        this.name = name;
        born = new GregorianCalendar(year, month, day);
        this.surname = surname;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public GregorianCalendar getBorn() {
        return born;
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "[ name = " + name
                + ", surname = " + surname
                + ", old = " + getOld()
                + "]";
    }

    public int getOld() {
        int old;
        GregorianCalendar now = new GregorianCalendar();
        old = now.get(GregorianCalendar.YEAR) - born.get(GregorianCalendar.YEAR);
        if (now.get(GregorianCalendar.MONTH) < born.get(GregorianCalendar.MONTH)) old--;
        if (now.get(GregorianCalendar.MONTH) == born.get(GregorianCalendar.MONTH)
                && now.get(GregorianCalendar.DATE) < born.get(GregorianCalendar.DATE)) old--;
        return old;
    }
}