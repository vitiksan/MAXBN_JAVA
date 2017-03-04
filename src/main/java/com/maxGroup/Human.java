package com.maxGroup;


import java.util.GregorianCalendar;

public class Human {
    private String name;
    private String surname;
    private GregorianCalendar born;

    public Human() {
        this.name = "Enter your name";
        this.surname = "Enter your surname";
        this.born = new GregorianCalendar(1970, 01, 01);
    }


    public Human(String name, String surname, int year, int month, int day) {
        this.name = name;
        this.born = new GregorianCalendar(year, month, day);
        this.surname = surname;

    }

    @Override
    public String toString() {
        return getClass().getName() +
                "[ name = " + name
                + ", surname = " + surname
                + ", date born = " + born.getGregorianChange()
                + "]";
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

    public void setBorn(GregorianCalendar born) {
        this.born = born;
    }
}
