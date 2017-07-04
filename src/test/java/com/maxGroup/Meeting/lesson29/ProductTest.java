package com.maxGroup.Meeting.lesson29;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class ProductTest {
    @Test
    public void getName() throws Exception {
        SortedSet<Product> products = new TreeSet<Product>();
        products.add(new Product("beer", 25.2));
        products.add(new Product("beer", 20.5));
        products.add(new Product("dark beer", 25.2));
        products.add(new Product("cheace", 40.2));
        products.add(new Product("nats", 15.2));
        products.add(new Product("fish", 25.2));

        System.out.println(products);
        System.out.println();

        NavigableSet<Product> sortByPrice = new TreeSet<Product>(Comparator.comparing(Product::getName));
        sortByPrice.addAll(products);

        System.out.println(sortByPrice);
    }

    @Test
    public void workWithPriorityQueue(){
        PriorityQueue<Product> products = new PriorityQueue<Product>(Comparator.comparing(Product::getName));
        products.add(new Product("beer", 25.2));
        products.add(new Product("dark beer", 25.2));
        products.add(new Product("cheace", 40.2));
        products.add(new Product("nats", 15.2));
        products.add(new Product("fish", 25.2));

        System.out.println(products);

        System.out.println(products.peek());

        System.out.println(products.poll());
        System.out.println(products.poll());
        System.out.println(products.poll());
    }

}