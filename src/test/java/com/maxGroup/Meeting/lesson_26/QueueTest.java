package com.maxGroup.Meeting.lesson_26;

import org.junit.Test;

import java.util.Collection;
import java.util.Iterator;

import static org.junit.Assert.*;

public class QueueTest {
    @Test
    public void add() throws Exception {
        Queue<String> queue = new Queue<String>();
        queue.addItem("04125");
        queue.addItem("0412251");
        queue.addItem("041gsjdigj");
        //Iterator<String> iterator = queue.iterator();
    while (!queue.isEmpty()){
        System.out.println(queue.remove());
    }

    }

}