package com.maxGroup.GRASP;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Sale {
    private GregorianCalendar date;
    private ArrayList<SaleItem> saleItems;


    public Sale() {
        saleItems = new ArrayList<SaleItem>();
        date = new GregorianCalendar();
    }

    public void addSaleItem(Product product, int q) {

        saleItems.add(new SaleItem(product, q));
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
