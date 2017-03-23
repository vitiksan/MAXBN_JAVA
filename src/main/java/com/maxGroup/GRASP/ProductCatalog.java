package com.maxGroup.GRASP;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductCatalog {
    private ArrayList<Product> products = null;

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
            System.out.println("id: " + item.getId() + " - " + item.getDescription());
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
}
