package com.maxGroup;


public class Consulter extends Employee {
    private String occupation;

    public Consulter() {
        super();
        occupation = "Credit";
    }

    public Consulter(String name, String surname, String post, int year, int month, int day,
                     int salary, String occupation, int yearStart, int mountStart, int dayStart) {
        super(name, surname, post, year, month, day, salary,yearStart,mountStart,dayStart);
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

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}