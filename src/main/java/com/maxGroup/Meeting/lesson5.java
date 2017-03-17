package com.maxGroup.Meeting;

import com.maxGroup.BankSystem.Consultant;
import com.maxGroup.BankSystem.Employee;
import com.maxGroup.BankSystem.Manager;

import java.util.ArrayList;

public class lesson5 {
    public static void main(String[] args) {
        double x = 3.15;
        int y = (int) x;

        ArrayList<Employee> staff = new ArrayList<Employee>();
        ArrayList<Manager> staff2 = new ArrayList<Manager>();

        staff.add(new Manager());
        staff.add(new Consultant());
        staff.add(new Manager());
        staff.add(new Consultant());

        Manager someBoss1 = (Manager) staff.get(1);

        for(Employee item: staff) {
            if (item instanceof Manager) {
                staff2.add((Manager) item);
            }
        }


    }
}
