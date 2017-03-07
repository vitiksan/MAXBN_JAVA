package com.maxGroup;


public class Consulter extends Employee {
    private String occupation;

    public Consulter() {
        super();
        this.occupation = "Credit";
    }

    public Consulter(String name, String surname, String post, int year, int month, int day, int experience, int cell, String occupation) {
        super(name, surname, post, year, month, day, experience, cell);
        this.occupation = occupation;
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
