package com.maxGroup.BankSystem.domain;


import com.maxGroup.BankSystem.supportClass.GenQueue;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Officer extends Employee implements Serializable, WorkWithClient {
    private static int nextId = 1;
    private int idOfficer;
    private GenQueue<Manager> subordinates;

    public Officer() {
        setName("none");
        setSurname("none");
        setBorn(new GregorianCalendar());
        setPost("none");
        setStartWork(new GregorianCalendar());
        setSalary(3000);
        subordinates = new GenQueue<Manager>(new Manager[10]);
        setIdOfficer();
    }


    /**
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
    public Officer(String name, String surname, String post, int year, int month, int day, int salary, int yearStart, int monthStart, int dayStart) {
        setName(name);
        setSurname(surname);
        setPost(post);
        setBorn(new GregorianCalendar(year, month, day));
        setSalary(salary);
        setStartWork(new GregorianCalendar(yearStart, monthStart, dayStart));
        subordinates = new GenQueue<Manager>(new Manager[10]);
        setIdOfficer();
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
    public Officer(String name, String surname, String post, int year, int month, int day, int salary) {
        setName(name);
        setSurname(surname);
        setPost(post);
        setBorn(new GregorianCalendar(year, month, day));
        setSalary(salary);
        subordinates = new GenQueue<Manager>(new Manager[10]);
        setIdOfficer();
    }


    public void setBonus() {
        setSalary(getSalary() * 1.1);
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "[ id = " + idOfficer +
                "[ name = " + getName()
                + ", surname = " + getSurname()
                + ", old = " + getOld()
                + ", post = " + getPost()
                + ", experience = " + getExperience()
                + " month, salary = " + getSalary()
                + ", subordinates = " + ""
                + "]";
    }

    public String showClient() {
        return subordinates.showAll();
    }

    public void addNewClient() {
        subordinates.push(new Manager());
    }

    public void deleteClient() {
        /*Scanner in = new Scanner(System.in);
        boolean find = false;
        try {
            for (Manager item : subordinates) System.out.println(item.toString());
            System.out.println("Enter surname manager for delete: ");
            String surname = in.nextLine();
            for (int i = 0; i < subordinates.size(); i++) {
                if (surname == subordinates.get(i).getSurname()) {
                    subordinates.remove(i);
                    find = true;
                }
            }
            if (!find) throw new Exception();
        } catch (Exception e) {
            System.out.println("Can`t find this surname");
            log.info("Can`t find this surname" + e.getMessage());
        }*/
    }

    public int getIdOfficer() {
        return idOfficer;
    }

    public void setIdOfficer() {
        idOfficer = nextId;
        nextId++;
    }

    public void setIdOfficer(int idOfficer) {
        this.idOfficer = idOfficer;
    }
}