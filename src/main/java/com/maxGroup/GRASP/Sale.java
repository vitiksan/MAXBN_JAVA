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

    public void addSaleItem(String descripton, double price, int q) {

        saleItems.add(new SaleItem(descripton, price, q));
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
}
