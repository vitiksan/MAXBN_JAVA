package com.maxGroup;

import com.maxGroup.BankSystem.domain.Customer;

import java.util.ArrayList;

public class CustomerTest {
    public static void main(String[] args) {
        ArrayList<Customer> group = new ArrayList<Customer>();

        group.add(new Customer("usual", "Vitalik", "Mah", 1997, 11, 29, 58000, 1111));
        group.add(new Customer("usual", "Olia", "Stefanishin", 1999, 3, 22, 68000, 1221));
        group.add(new Customer("usual", "Igor", "Kupchak", 1997, 5, 11, 36000, 3251));

        int sum = 0;
        for (Customer item : group) {
            System.out.println(item.toString());
            item.createAccount(2000, 12345);
        }

        for (Customer item : group) {
            System.out.println(item.toString());
            sum += item.getBalanceAccounts();
        }
        System.out.println("All sum accounts group: " + sum);

    }

}