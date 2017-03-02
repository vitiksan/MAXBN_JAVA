package com.maxGroup;


public class Employee extends Human {
    private String post;
    private int experience;

    public Employee() {
        post = "trainee";
        experience = 0;
    }

    public Employee(String name, String surname, String post, int old, int experience) {
        setName(name);
        setSurname(surname);
        setPost(post);
        setOld(old);
        setExperience(experience);
    }
    @Override
    public String toString() {
        System.out.println("Name: " + getName());
        System.out.println("Surname: " + getSurname());
        System.out.println("Old: " + getOld());
        System.out.println("Post: " + post);
        System.out.println("Experience: " + experience);
        return null;
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

