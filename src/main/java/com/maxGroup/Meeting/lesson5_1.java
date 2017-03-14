package com.maxGroup.Meeting;

import com.maxGroup.BankSystem.Employee;

public class lesson5_1 {
    public static void main(String[] args) {
        double salary = 1000;
        riseTo(salary);
        System.out.println("Salary = " + salary);

        Employee em1 = new Employee();
        Employee em2 = new Employee();
        riseTo(em1);
        System.out.println(em1.toString());
        System.out.println("After swap: ");
        swap(em1,em2);
        System.out.println(em1.toString());
        System.out.println(em2.toString());



    }
    public static void swap(Employee x, Employee y){
        Employee temp = x;
        x = y;
        y = temp;
    }

    public static void riseTo(double x) {
        x = 3 * x;
    }

    public static void riseTo(Employee x) {
        x.riseSalary(200);
    }
}
