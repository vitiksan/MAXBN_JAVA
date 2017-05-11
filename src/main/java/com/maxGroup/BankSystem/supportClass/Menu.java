package com.maxGroup.BankSystem.supportClass;

import org.apache.log4j.Logger;

import java.util.Scanner;

public class Menu {
    private static final Logger log = Logger.getLogger(Menu.class);
    private static int choose = -1;

    public static void main(String[] args) {
        System.out.println("Welcome to shop");
        do {
            information();
            choose = chooses();
            done(choose);
        } while (choose != 0);
    }

    private static void done(int temp) {
        switch (temp) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 0:
                System.exit(0);
                break;
            default:
                break;
        }

    }

    private static int chooses() {
        Scanner in = new Scanner(System.in);
        int temp = -1;
        do {
            try {
                System.out.print("Please enter your choices: ");
                temp = Integer.parseInt(in.next());
                if (temp > 4) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Your choices not defined");
                log.error("Your choices not defined");
                log.error(e.getMessage());
                temp = -1;
            }
        } while (temp < 0);
        return temp;
    }

    private static void information() {
        System.out.println("You can:");
        System.out.println("1-Create new Manager");
        System.out.println("2-Create new Customer");
        System.out.println("3-Crete new Account for Customer");
        System.out.println("4-Read all Manager");
        System.out.println("5-Read all Customer");
        System.out.println("5-Read all Account by Customer");
        System.out.println("0-Exit");
    }
}