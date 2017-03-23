package com.maxGroup.Meeting.lesson8;

import java.io.IOException;

public class lesson8 {
    public static void main(String[] args) {
        try {
            demo();
        } catch (IOException e) {
            System.out.println("Repeat handler");
            System.out.println(e.getMessage());
        } finally {

        }
    }

    static void demo() throws IOException, NullPointerException {
            throw new IOException("DEMO");
    }

    /*ArithmeticException
    ArrayIndexOutOfBoundsException
            ClassCastException
    NullPointerException
                    IndexOutOfBoundsException
    ClassNotFoundException*/

}
