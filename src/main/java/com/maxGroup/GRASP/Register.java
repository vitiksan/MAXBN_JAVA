package com.maxGroup.GRASP;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class Register {
    private static final Logger log = Logger.getLogger(Register.class);
    private static ArrayList<Sale> sales = new ArrayList<Sale>();


    public static Sale newSale() {
        Sale temp = new Sale();
        sales.add(temp);
        return temp;
    }

    public static void addItemsToSale(Sale sale) {
        Scanner in = new Scanner(System.in);
        int closeSale = -1;
        do {
            try {
                Product tempProd = ProductCatalog.choose();
                System.out.println("How much?");
                int quantity = Integer.parseInt(in.next());
                if (quantity <= 0) throw new Exception();

                sale.addSaleItem(tempProd, quantity);
                System.out.print("Do you want add something else?(1-Yes, 0-No): ");
                closeSale = Integer.parseInt(in.next());
                if (closeSale != 0 && closeSale != 1) throw new Exception();
            } catch (NullPointerException e) {
                System.out.println("Використовується об'єктну ссилку що рівна null");
                log.error("Використовується об'єктну ссилку що рівна null");
                log.error(e.getMessage());
            } catch (Exception e) {
                System.out.println("Невірно введено кількість або ID товару");
                log.error("Невірно введено кількість або ID товару");
                log.error(e.getMessage());
                closeSale = -1;
            }
        } while (closeSale != 0);
        log.info(sale.generateCheck());
        System.out.println(sale.generateCheck());
    }

    public static void addProduct(String description, double price) {
        ProductCatalog.setProducts(description, price);
        ProductCatalog.saveData();
    }

    public static void addProduct() {
        Scanner in = new Scanner(System.in);
        String description;
        double price;
        try {
            System.out.print("Назва продукту: ");
            description = in.next();
            System.out.print("Ціна за одиницю товару: ");
            price = Double.parseDouble(in.next());
            if (price < 0) {
                throw new Exception("Price less than 0");
            }
            ProductCatalog.setProducts(description, price);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        ProductCatalog.saveData();
    }
}
