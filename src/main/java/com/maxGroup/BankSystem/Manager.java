package com.maxGroup.BankSystem;


import org.apache.log4j.Logger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Manager extends Employee implements Serializable, WorkWithClient {
    private static final Logger log = Logger.getLogger(Manager.class);
    private ArrayList<Customer> clients;

    public Manager() {
        setName("none");
        setSurname("none");
        setBorn(new GregorianCalendar());
        setPost("none");
        setStartWork(new GregorianCalendar());
        setSalary(3000);
        clients = new ArrayList<Customer>();
    }

    /**
     * Конструктор
     *
     * @param name       - Ім'я
     * @param surname    - Прізвище
     * @param post       - Посада працівника
     * @param year       - Рік народження
     * @param month      - Місяць народженя
     * @param day        - День народження
     * @param salary     - Зарплата
     * @param yearStart  - Рік початку роботи
     * @param monthStart - Місяць початку роботи
     * @param dayStart   - День початку роботи
     */
    public Manager(String name, String surname, String post, int year, int month, int day, int salary, int yearStart, int monthStart, int dayStart) {
        setName(name);
        setSurname(surname);
        setPost(post);
        setBorn(new GregorianCalendar(year, month, day));
        setSalary(salary);
        setStartWork(new GregorianCalendar(yearStart, monthStart, dayStart));
        clients = new ArrayList<Customer>();
    }

    /**
     * Конструктор
     *
     * @param name    - Ім'я
     * @param surname - Прізвище
     * @param post    - Посада працівника
     * @param year    - Рік народження
     * @param month   - Місяць народженя
     * @param day     - День народження
     * @param salary  - Зарплата
     */
    public Manager(String name, String surname, String post, int year, int month, int day, int salary) {
        setName(name);
        setSurname(surname);
        setPost(post);
        setBorn(new GregorianCalendar(year, month, day));
        setSalary(salary);
        clients = new ArrayList<Customer>();
    }

    public void setBonus() {
        setSalary(getSalary() * 1.25);
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "[ name = " + getName()
                + ", surname = " + getSurname()
                + ", old = " + getOld()
                + ", post = " + getPost()
                + ", experience = " + getExperience()
                + " month, cell = " + getSalary()
                + ", clients = " + ""
                + "]";
    }

    public String showClient() {
        String temp = "";
        for (Customer item : clients) temp += item.toString();
        return temp;
    }

    public void addNewClient() {
        clients.add(new Customer());
    }

    public void deleteClient() {
        Scanner in = new Scanner(System.in);
        boolean find = false;
        try {
            for (Customer item : clients) System.out.println(item.toString());
            System.out.println("Enter surname customer for delete: ");
            String surname = in.nextLine();
            for (int i = 0; i < clients.size(); i++) {
                if (surname == clients.get(i).getSurname()) {
                    clients.remove(i);
                    find = true;
                }
            }
            if (!find) throw new Exception();
        } catch (Exception e) {
            System.out.println("Can`t find this surname");
            log.info("Can`t find this surname" + e.getMessage());
        }
    }
}