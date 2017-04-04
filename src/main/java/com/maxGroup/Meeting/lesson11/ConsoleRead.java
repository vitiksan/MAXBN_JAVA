package com.maxGroup.Meeting.lesson11;

import java.util.Scanner;

public class ConsoleRead implements IRead {
    public String read() {
        Scanner in = new Scanner(System.in);
        String temp = in.nextLine();
        return temp;
    }
}
