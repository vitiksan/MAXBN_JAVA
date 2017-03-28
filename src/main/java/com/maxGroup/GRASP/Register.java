package com.maxGroup.GRASP;

import java.util.ArrayList;

public class Register {
    private ArrayList<Sale> sales = null;
    private ProductCatalog catalog = null;

    public Sale newSale() {
        Sale temp = new Sale();
        sales.add(temp);
        return temp;
    }

    public void addItemsToSale(Sale sale) {

        Product tempProd = catalog.choose();
        System.out.println("How much?");

        sale.addSaleItem("milk", 50, 6);
    }
    public void addProduct(String description, double price) {
        catalog.setProducts(description, price);
    }


}
