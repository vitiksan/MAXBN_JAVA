package com.maxGroup.Meeting.lesson15;

public class Runner {
    public static void main(String[] args) {
        Integer[] x = {2, 6, 2, 8, 5, 9};
        Double[] y = {2.5, 6.2, 2.9, 8.65, 5.33, 9.5};
        //String[] c = {"fhdj","djrf","tyufnd"};
        //Status<String> cl = new Status<String>(c);  Error
        Status<Integer> xl = new Status<Integer>(x);
        Status<Double> yl = new Status<Double>(y);
        System.out.println(xl.avg());
        System.out.println(yl.avg());
        //System.out.println(cl.avg());
        System.out.println(xl.compareAvg(yl));
    }
}
