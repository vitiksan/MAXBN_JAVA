package com.maxGroup.BankSystem;

import java.io.*;

public class Serializator {


    public static void saveData(String path, Object obj) {
        try {
            FileOutputStream someFile = new FileOutputStream(path + ".ser");
            ObjectOutputStream someObj = new ObjectOutputStream(someFile);

            someObj.writeObject(obj);
            someFile.close();
            someObj.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return temp;
    }
}