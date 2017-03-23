package com.maxGroup.GRASP;

public class Product {
    private static int nextID = 1;
    private String description;
    private double price;
    private int id;

    public Product() {
        description = "none";
        price = 0.0;
        setId();
    }

    public Product(String description, double price, int id) {
        this.description = description;
        this.price = price;
        this.id = id;
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


    @Override
    public String toString() {
        return "Product{" +
                "description='" + description + '\'' +
                ", price=" + price +
                ", id=" + id +
                '}';
    }
}
