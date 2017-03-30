package com.maxGroup.GRASP;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class Register {
    private static final Logger log = Logger.getLogger(Register.class);
    private ArrayList<Sale> sales = null;
    private ProductCatalog catalog = null;

    public Register(ProductCatalog catalog) {
        this.catalog = catalog;
        sales = new ArrayList<Sale>();
    }

    public Sale newSale() {
        Sale temp = new Sale();
        sales.add(temp);
        return temp;
    }

    public void addItemsToSale(Sale sale, ProductCatalog) {
        Scanner in = new Scanner(System.in);
        boolean closeSale = false;
        do {
            Product tempProd = catalog.choose();
            System.out.println("How much?");
            int quantity = Integer.parseInt(in.next());
            sale.addSaleItem(tempProd, quantity);
            System.out.print("Do you want add something else?(1-Yes, 0-No): ");
            closeSale = Boolean.parseBoolean(in.next());
        } while (!closeSale);

    }

    public void addProduct(String description, double price) {
        catalog.setProducts(description, price);
    }

    public void addProduct() {
        Scanner in = new Scanner(System.in);
        String description;
        double price;
        try {
            description = in.next();
            price = Double.parseDouble(in.next());
            catalog.setProducts(description, price);
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

}
