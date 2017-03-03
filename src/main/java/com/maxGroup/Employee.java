package com.maxGroup;


public class Employee extends Human {
    private String post;
    private int experience;

    public Employee() {
        super();
        post = "trainee";
        experience = 0;
    }

    public Employee(String name, String surname, String post, int year, int month, int day, int experience) {
        super(name, surname, year, month, day);
        setPost(post);
        setExperience(experience);
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "[ name = " + getName()
                + ", surname = " + getSurname()
                + ", date born = " + born.getGregorianChange()
                + ", post = " + post
                + ", experience = " + experience
                + "]";
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

