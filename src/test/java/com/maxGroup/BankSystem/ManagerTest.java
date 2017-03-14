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

        for (Employee human:staff){
            System.out.println(human.toString());
        }

        for (Employee human:staff){
            human.riseSalary(500);
        }

        System.out.println("---------------");

        for (Employee human:staff){
            System.out.println(human.toString());
        }


    }

}