package com.maxGroup.GRASP;

public class ProductSpecification {
    private String description;
    private double price;
    private int id;

    public ProductSpecification() {
        description = "none";
        price = 0.0;
        id = 0;
    }

    public ProductSpecification(String description, double price, int id) {
        this.description = description;
        this.price = price;
        this.id = id;
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

    @Override
    public String toString() {
        return "ProductSpecification{" +
                "description='" + description + '\'' +
                ", price=" + price +
                ", id=" + id +
                '}';
    }
}
