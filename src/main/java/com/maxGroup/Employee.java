package com.maxGroup;


public class Employee extends Human {
    private String post;
    private int experience;
    private int cell;

    public Employee() {
        super();
        this.post = "trainee";
        this.experience = 0;
        this.cell = 3000;
    }

    public Employee(String name, String surname, String post, int year, int month, int day, int experience, int cell) {
        super(name, surname, year, month, day);
        this.post = post;
        this.experience = experience;
        this.cell = cell;
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "[ name = " + getName()
                + ", surname = " + getSurname()
                + ", date born = " + getBorn().getGregorianChange()
                + ", post = " + post
                + ", experience = " + experience
                + ", cell = " + cell
                + "]";
    }

    public int getCell() {
        return cell;
    }

    public void setCell(int cell) {
        this.cell = cell;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}

