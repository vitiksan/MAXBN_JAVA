package com.maxGroup.Meeting.lesson12_abstractFactory;

import java.util.GregorianCalendar;

public interface IEmployee {
    public void setName(String name);
    public String getSurname();
    public void setSurname(String surname);
    public GregorianCalendar getBorn();
    public void setBorn(GregorianCalendar born);
    public int getOld();
    public double getSalary();
    public void setSalary(double salary);
    public String getPost();
    public void setPost(String post);
    public GregorianCalendar getStartWork();
    public void setStartWork(GregorianCalendar startWork);
    public Boolean riseSalary(int count);
    public Boolean reduceSalary(int count);
    public int getExperience();
    public void setBonus();
}
