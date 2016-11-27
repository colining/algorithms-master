package com.company;

import algorithms.ClosestPoints;
import algorithms.KMP;
import model.Point;

public class KmpDemo {

    public static void main(String[] args) {

        KMP kmp = new KMP();
       char a[]  = {'a','b','c','f','p','o'};
        char b[] = {'c','f','\0'};
        String a1 = "acdfe";
        String b1 = "fe";
        System .out .print(kmp.indexOf(a1,b1));


    }
}
