package com.maxGroup;


public class Officer extends Employee {
    private int levelOfGovernment;

    public Officer() {
        super();
        this.levelOfGovernment = 1;
    }

    public Officer(String name, String surname, String post, int year, int month, int day, int experience, int cell, int levelOfGovernment) {
        super(name, surname, post, year, month, day, experience, cell);
        this.levelOfGovernment = levelOfGovernment;
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "[ name = " + getName()
                + ", surname = " + getSurname()
                + ", date born = " + getBorn().getGregorianChange()
                + ", post = " + getPost()
                + ", experience = " + getExperience()
                + ", cell = " + getCell()
                + ", level of government = " + levelOfGovernment
                + "]";
    }

    public int getLevelOfGovernment() {
        return levelOfGovernment;
    }

    public void setLevelOfGovernment(int levelOfGovernment) {
        this.levelOfGovernment = levelOfGovernment;
    }
}
