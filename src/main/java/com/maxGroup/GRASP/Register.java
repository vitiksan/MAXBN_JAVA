package com.maxGroup.GRASP;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class Register {
    private static final Logger log = Logger.getLogger(Register.class);
    private ArrayList<Sale> sales = null;
    private ProductCatalog catalog = null;

    public Register(ProductCatalog catalog) {
        this.catalog = catalog;
        sales = new ArrayList<Sale>();
    }

    public Sale newSale() {
        Sale temp = new Sale();
        sales.add(temp);
        return temp;
    }

    public void addItemsToSale(Sale sale) {
        Scanner in = new Scanner(System.in);
        boolean closeSale = false;
        do {
            try {
                Product tempProd = catalog.choose();
                System.out.println("How much?");
                int quantity = Integer.parseInt(in.next());
                if(quantity<=0){
                    throw new Exception();
                }
                sale.addSaleItem(tempProd, quantity);
                System.out.print("Do you want add something else?(1-Yes, 0-No): ");
                closeSale = Boolean.parseBoolean(in.next());
            }
            catch (NullPointerException e) {
                System.out.println("Використовується об'єктну ссилку що рівна null");
                log.error("Використовується об'єктну ссилку що рівна null");
                log.error(e.getMessage());
            }catch (ClassCastException e) {
                System.out.println("Невірний вибрано дію");
                log.error("Невірний вибрано дію");
                log.error(e.getMessage());
                closeSale = false;
            }catch (Exception e){
                System.out.println("Невірно введено кількість товару");
                log.error("Невірно введено кількість товару");
                log.error(e.getMessage());
            }
        } while (!closeSale);
    }

    public void addProduct(String description, double price) {
        catalog.setProducts(description, price);
    }

    public void addProduct() {
        Scanner in = new Scanner(System.in);
        String description;
        double price;
        try {
            description = in.next();
            price = Double.parseDouble(in.next());
            if (price<0){
                throw new Exception("Price less than 0");
            }
            catalog.setProducts(description, price);
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }
}
