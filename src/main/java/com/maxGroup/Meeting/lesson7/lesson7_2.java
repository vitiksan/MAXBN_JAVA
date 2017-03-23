package com.maxGroup.Meeting.lesson7;

import org.apache.log4j.Logger;

import java.util.Random;

public class lesson7_2 {
    private static final Logger log = Logger.getLogger(lesson7_2.class);

    public static void main(String[] args) {
        /*
        try catch throw thows finally
         */
        subProgram();
    }

    public static void subProgram() {
        int a = 0, b = 0, c = 0;
        Random random = new Random();
        int counter = 0;
        int someArray[] = new int[150];


        for (int i = 0; i < 200; i++) {
            try {
                b = random.nextInt(50);
                c = random.nextInt(50);
                a = 5096 / (b / c);
                someArray[i] = a;
                System.out.println("В тілі try");
            } catch (ArithmeticException e) {
                System.out.println("Виняток " + e);
                log.error("Виняток " + e);
                a = 0;
                counter++;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Виняток " + e);
                log.error("Виняток " + e);
            }
            System.out.println("a = " + a);
            log.info("a = " + a);
        }

        System.out.println("Counter = " + counter);
        log.info("Counter = " + counter);
    }

}
