package com.maxGroup.GRASP;

import org.apache.log4j.Logger;

import java.util.Scanner;

public class Menu {
    private static final Logger log = Logger.getLogger(Menu.class);
    private static Register register = new Register(ProductCatalog.getData());
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
                register.addItemsToSale(register.newSale());
                break;
            case 2:
                register.addProduct();
                break;
            case 3:

                break;
            case 4:
                break;
            case 5:
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
                System.out.print("Please enter your choise: ");
                temp = Integer.parseInt(in.next());
                if (temp > 5) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Введено не існуючий пункт меню");
                log.error("Введено не існуючий пункт меню");
                log.error(e.getMessage());
                temp = -1;
            }
        } while (temp < 0);
        return temp;
    }

    private static void information() {
        System.out.println("You can:");
        System.out.println("1-Create sale");
        System.out.println("2-Add new product");
        System.out.println("3-Add new product to sale");
        System.out.println("4-Show sale`s price");
        System.out.println("5-Buy products");
        System.out.println("0-Exit");
    }
}
