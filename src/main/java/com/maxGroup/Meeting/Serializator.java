package com.maxGroup.Meeting;

import com.maxGroup.BankSystem.Customer;
import com.maxGroup.BankSystem.Manager;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Serializator {
    private static ArrayList<Customer> customers = new ArrayList<Customer>();
    private static ArrayList<Manager> managers = new ArrayList<Manager>();

    public static void main(String[] args) {
        /*customers = (ArrayList<Customer>) getData("customers");
        System.out.println("ArrayList size before = " + customers.size());

        Customer cm = new Customer();
        cm.setName(JOptionPane.showInputDialog(null, "Імя клієнта"));
        cm.setSurname(JOptionPane.showInputDialog(null, "Прізвище клієнта"));

        customers.add(cm);

        for (Customer customer : customers) System.out.println(customer.toString());

        System.out.println("ArrayList size after = " + customers.size());
        saveData("customers", customers);
        */
        managers = (ArrayList<Manager>) getData("managers");
        System.out.println("ArrayList size before = " + managers.size());
        Manager manager = new Manager();
        manager.setName(JOptionPane.showInputDialog(null, "Імя клієнта"));
        manager.setSurname(JOptionPane.showInputDialog(null, "Прізвище клієнта"));

        managers.add(manager);

        for (Manager item: managers) System.out.println(item.toString());

        System.out.println("ArrayList size after = " + managers.size());
        saveData("managers",managers);
    }


    private static void saveData(String path, Object obj) {
        try {
            FileOutputStream someFile = new FileOutputStream(path + ".ser");
            ObjectOutputStream someObj = new ObjectOutputStream(someFile);

            someObj.writeObject(obj);
            someFile.close();
            someObj.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Object getData(String path) {
        Object temp = null;
        try {
            FileInputStream someFile = new FileInputStream(path + ".ser");
            ObjectInputStream someObj = new ObjectInputStream(someFile);

            temp = someObj.readObject();
            someFile.close();
            someObj.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return temp;
    }
}