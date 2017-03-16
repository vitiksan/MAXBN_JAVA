package com.maxGroup.BankSystem;


import java.util.GregorianCalendar;

public abstract class Human {
    private String name;
    private String surname;
    private GregorianCalendar born;

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