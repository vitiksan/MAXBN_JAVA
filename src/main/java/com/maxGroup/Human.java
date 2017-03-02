package com.maxGroup;


public abstract class Human {
    private String name;
    private String surname;
    private int old;

    public Human() {
        name = "Enter your name";
        surname = "Enter your surname";
        old = 0;
    }

    public Human(String name, String surname, int old) {
        setName(name);
        setOld(old);
        setSurname(surname);
    }
    @Override
    public String toString() {
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Old: " + old);
        return null;
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

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }
}
