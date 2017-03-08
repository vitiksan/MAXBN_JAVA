package com.maxGroup;


public class Officer extends Employee {
    private String levelOfGovernment;

    public Officer() {
        super();
        levelOfGovernment = "";
    }

    public Officer(String name, String surname, String post, int year, int month, int day, int salary,
                   String levelOfGovernment, int yearStart, int mountStart, int dayStart) {
        super(name, surname, post, year, month, day, salary,yearStart,mountStart,dayStart);
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

    public String  getLevelOfGovernment() {
        return levelOfGovernment;
    }

    public void setLevelOfGovernment(String levelOfGovernment) {
        this.levelOfGovernment = levelOfGovernment;
    }
}
