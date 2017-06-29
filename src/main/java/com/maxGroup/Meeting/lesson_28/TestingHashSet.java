package com.maxGroup.Meeting.lesson_28;

import java.io.*;
import java.util.*;

public class TestingHashSet {
    public static void main(String[] args) throws FileNotFoundException {
        Set<String> words = new TreeSet<String>();
        long sumarrytime = 0;

        String loadFile = loadData("./src/main/java/com/maxGroup/Meeting/lesson_28/book.txt");
        ByteArrayInputStream bais = new ByteArrayInputStream(loadFile.getBytes());
        System.setIn(bais);
        try (Scanner input = new Scanner(System.in)) {
            while (input.hasNext()) {
                String word = input.next();
                long spentTime = System.currentTimeMillis();
                words.add(word);
                spentTime = System.currentTimeMillis() - spentTime;
                sumarrytime += spentTime;
            }
        }

        Iterator<String> iterator = words.iterator();
        for (int i = 1; i <= 20 && iterator.hasNext(); i++) {
            System.out.println(iterator.next());
        }
        System.out.println();
        System.out.println("Collection size = " + words.size());
        System.out.println("Total time = " + sumarrytime);
        System.out.println("Total time in second = " + sumarrytime / 60000);
    }

    public static String loadData(String path) throws FileNotFoundException {
        StringBuilder str = new StringBuilder();
        File file = new File(path);

        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    str.append(s);
                    str.append("\n");
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return str.toString();
    }
}
