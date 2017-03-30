package com.maxGroup.GRASP;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductCatalog {
    private static final Logger log = Logger.getLogger(ProductCatalog.class);
    private static ArrayList<Product> products = null;

    public ProductCatalog() {
        products = new ArrayList<Product>();
    }

    public ProductCatalog(ArrayList<Product> products) {
        this.products = new ArrayList<Product>(products);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(String description, double price) {
        products.add(new Product(description, price));
    }

    public Product choose() {
        for (Product item : products) {
            System.out.println(item.toString());
        }

        System.out.println("Select product by id: ");
        Scanner input = new Scanner(System.in);

        int selection = input.nextInt();

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == selection) {
                selection = i;
                break;
            }
        }
        return products.get(selection);
    }

    public static void saveData() {
        try {
            FileOutputStream someFile = new FileOutputStream("ProductCatalog.ser");
            ObjectOutputStream someObj = new ObjectOutputStream(someFile);
            someObj.writeObject(products);
            someFile.close();
            someObj.close();

        } catch (FileNotFoundException e) {
            System.out.println("Виняток " + e);
            log.error("Виняток " + e);
        } catch (IOException e) {
            System.out.println("Виняток " + e);
            log.error("Виняток " + e);
        } catch (NullPointerException e) {
            System.out.println("Виняток " + e);
            log.error("Виняток " + e);
        }
    }

    public static void getData() {
        try {
            FileInputStream someFile = new FileInputStream("ProductCatalog.ser");
            ObjectInputStream someObj = new ObjectInputStream(someFile);

            products =(ArrayList<Product>) someObj.readObject();
            someFile.close();
            someObj.close();

        } catch (FileNotFoundException e) {
            System.out.println("Виняток " + e);
            log.error("Виняток " + e);
        } catch (IOException e) {
            System.out.println("Виняток " + e);
            log.error("Виняток " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("Виняток " + e);
            log.error("Виняток " + e);
        }
    }
}
