package com.maxGroup.GRASP;

public class SaleItem{
    private Product item = null;
    private int quantity;

    public SaleItem() {
        item = new Product();
        quantity = 0;
    }

    public SaleItem(String description, double price, int quantity) {
        item = new Product(description,price);
        this.quantity = quantity;
    }
    public SaleItem(Product product, int quantity) {
        item = product;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "SaleItem{" +
                "quantity=" + quantity +
                '}';
    }
    public double getSubTotal(){
        return item.getPrice()*quantity;
    }
}
