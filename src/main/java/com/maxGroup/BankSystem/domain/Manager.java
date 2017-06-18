package com.maxGroup.BankSystem.domain;


import com.maxGroup.BankSystem.DAO.Identificator;
import com.maxGroup.BankSystem.supportClass.GenQueue;

public class Manager extends Employee implements Identificator<Integer> {
    private int id;
    private GenQueue<Customer> clients;

    @Override
    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public String showClient() {
        return clients.showAll();
    }

    public void addNewClient() {
        clients.push(new Customer(id));
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "[ id = " + id +
                ", name = " + getName()
                + ", surname = " + getSurname()
                + ", old = " + getOld()
                + ", post = " + getPost()
                + ", experience = " + getExperience()
                + " month, cell = " + getSalary()
                + ", clients = " + showClient()
                + "]";
    }

    public void setBonus() {
        setSalary(getSalary() * 1.25);
    }
}