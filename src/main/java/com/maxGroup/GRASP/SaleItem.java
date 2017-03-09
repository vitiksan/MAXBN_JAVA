package com.maxGroup.GRASP;



public class SaleItem extends ProductSpecification {
    private int quantity;

    public SaleItem() {
        super();
        quantity = 0;
    }

    public SaleItem(String description, double price, int id, int quantity) {
        super(description, price, id);
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
        return getPrice()*quantity;
    }
}
