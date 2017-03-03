package com.maxGroup;


import java.util.GregorianCalendar;

public class Human {
    private String name;
    private String surname;
    GregorianCalendar born;

    public Human() {
        name = "Enter your name";
        surname = "Enter your surname";
        born = new GregorianCalendar(1970, 01, 01);
    }

    public Human(String name, String surname, int year, int month, int day) {
        setName(name);
        born = new GregorianCalendar(year, month, day);
        setSurname(surname);
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
}
