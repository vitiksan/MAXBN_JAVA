package com.maxGroup.GRASP;

public class Runner {
    public static void main(String[] args) {
        Sale sale = new Sale();
        sale.addSaleItem(new SaleItem("milk", 10.5, 1, 5));
        sale.addSaleItem(new SaleItem("meat", 50.5, 2, 10));
        sale.addSaleItem(new SaleItem("tea", 20.5, 3, 3));
        System.out.println("full price = " + sale.getTotal());
    }
}
