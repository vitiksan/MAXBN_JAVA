package com.maxGroup.GRASP;

import java.io.Serializable;

public class Product implements Serializable, infoProduct {
    private static int nextID = 1;
    private String description;
    private double price;
    private int id;

    public Product() {
        description = "none";
        price = 0.0;
        setId();
    }

    public Product(String description, double price) {
        this.description = description;
        this.price = price;
        setId();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId() {
        id = nextID;
        nextID++;
    }

    public static void setNextID(int id) {
        nextID = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id = " + id +
                ", description = " + description +
                ", price = " + price +
                '}';
    }

    public String generateCheck() {
        return id + "\t\t\t" + description + "\t\t\t" + price + "\t\t\t";
    }
}
