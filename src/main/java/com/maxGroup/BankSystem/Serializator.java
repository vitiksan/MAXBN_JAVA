package com.maxGroup.BankSystem;

import org.apache.log4j.Logger;

import java.io.*;

public class Serializator {
    private static final Logger log = Logger.getLogger(Serializator.class);

    public static void saveData(String path, Object obj) {
        try {
            FileOutputStream someFile = new FileOutputStream(path + ".ser");
            ObjectOutputStream someObj = new ObjectOutputStream(someFile);
            someObj.writeObject(obj);
            someFile.close();
            someObj.close();

        } catch (FileNotFoundException e) {
            System.out.println("Виняток " + e);
            log.error("Виняток " + e);
        } catch (IOException e) {
            System.out.println("Виняток " + e);
            log.error("Виняток " + e);
        } catch (NullPointerException e) {
            System.out.println("Виняток " + e);
            log.error("Виняток " + e);
        }
    }

    public static Object getData(String path) {
        Object temp = null;
        try {
            FileInputStream someFile = new FileInputStream(path + ".ser");
            ObjectInputStream someObj = new ObjectInputStream(someFile);

            temp = someObj.readObject();
            someFile.close();
            someObj.close();

        } catch (FileNotFoundException e) {
            System.out.println("Виняток " + e);
            log.error("Виняток " + e);
        } catch (IOException e) {
            System.out.println("Виняток " + e);
            log.error("Виняток " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("Виняток " + e);
            log.error("Виняток " + e);
        }
        return temp;
    }
}