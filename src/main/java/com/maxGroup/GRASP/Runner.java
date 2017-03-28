package com.maxGroup.GRASP;

public class Runner {
    public static void main(String[] args) {
        Sale sale = new Sale();
        sale.addSaleItem("milk", 10.5, 5);
        sale.addSaleItem("meat", 50.5, 10);
        sale.addSaleItem("tea", 20.5, 3);
        System.out.println("full price = " + sale.getTotal());
    }
}
