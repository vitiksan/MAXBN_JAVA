package com.maxGroup;

import com.maxGroup.BankSystem.Employee;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class EmployeeTest {
    @Test
    public void getExperience() throws Exception {
        GregorianCalendar now = new GregorianCalendar();
        int yearStart = now.get(GregorianCalendar.YEAR) - 2;
        int monthStart = now.get(GregorianCalendar.MONTH) + 3;
        int dayStart = now.get(GregorianCalendar.DATE) - 10;
        //experience = 12*2-3+1 = 22 month

        Employee person = new Employee("Vitalik", "Mah", "developer", 1997, 11, 29, 5000, yearStart, monthStart, dayStart);
        assertEquals(22, person.getExperience());
    }

}