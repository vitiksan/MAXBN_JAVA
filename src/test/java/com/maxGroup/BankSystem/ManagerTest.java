package com.maxGroup.BankSystem;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ManagerTest {
    @Test
    public void riseSalary() throws Exception {
        ArrayList<Employee> staff = new ArrayList<Employee>();

        staff.add(new Employee());
        staff.add(new Manager());
        staff.add(new Consulter());
        staff.add(new Manager());
        staff.add(new Consulter());
        staff.add(new Employee());

        for (Employee human : staff) {
            System.out.println(human.toString());
        }

        for (Employee human : staff) {
            human.riseSalary(500);
        }

        System.out.println("---------------");

        for (Employee human : staff) {
            System.out.println(human.toString());
        }


    }

    @Test //TODO Task 5001
    public void setBonus() throws Exception {
        ArrayList<Employee> staff = new ArrayList<Employee>();
        staff.add(new Employee());
        staff.add(new Manager());

        int salary = 5000;

        for (Employee human : staff) {
            human.setSalary(salary);
            human.setBonus();
        }
        assertEquals(salary * 1.10, staff.get(0).getSalary(), 0);
        assertEquals(salary * 1.25, staff.get(1).getSalary(), 0);
    }

}