package com.maxGroup.GRASP;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Sale {
    private GregorianCalendar date;
    private ArrayList<SaleItem> saleItems;
    private int idSale;
    private static int nextIdSale = 1;


    public Sale() {
        saleItems = new ArrayList<SaleItem>();
        date = new GregorianCalendar();
        setIdSale();
    }

    public void addSaleItem(String description, double price, int q) {

        saleItems.add(new SaleItem(description, price, q));
    }

    public void addSaleItem(Product product, int q) {

        saleItems.add(new SaleItem(product, q));
    }

    public void setIdSale() {
        idSale = nextIdSale;
        nextIdSale++;
    }

    public ArrayList<SaleItem> getSaleItems() {
        return saleItems;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public double getTotal() {
        double fullPrice = 0;
        for (SaleItem item : saleItems) {
            fullPrice += item.getSubTotal();
        }
        return fullPrice;
    }

    public String generateCheck() {
        String temp = "*****************************\n";
        temp += "Номер чеку: " + idSale + "\n";
        temp += "ID товар\tНазва товару\tЦіна за одиницю\tКількість\tЦіна\n";
        for (SaleItem item : saleItems) temp += item.generateCheck() + "\n";
        temp += "Загальна сума: \t\t\t\t" + getTotal() + "\n";
        temp += "Дата генераці чеку\t\t\t" + date.getGregorianChange();
        temp += "\n***********************";
        return temp;
    }
}
