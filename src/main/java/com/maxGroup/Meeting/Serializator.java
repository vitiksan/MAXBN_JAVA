package com.maxGroup.Meeting;

import com.maxGroup.BankSystem.Customer;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Serializator {
    private static ArrayList<Customer> customers = new ArrayList<Customer>();

    public static void main(String[] args) {
        customers = (ArrayList<Customer>) getData("customers");
        System.out.println("ArrayList size before = " + customers.size());

        Customer cm = new Customer();
        cm.setName(JOptionPane.showInputDialog(null, "Імя клієнта"));
        cm.setSurname(JOptionPane.showInputDialog(null, "Прізвище клієнта"));

        customers.add(cm);

        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }

        System.out.println("ArrayList size after = " + customers.size());
        saveData("customers", customers);
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
