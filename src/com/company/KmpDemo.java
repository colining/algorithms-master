package com.company;

import algorithms.ClosestPoints;
import algorithms.KMP;
import model.Point;

public class KmpDemo {

    public static void main(String[] args) {
//	ClosestPoints closestPoints = new ClosestPoints();
//        Point point1 = new Point(0,0);
//        Point point2 = new Point( 0,1);
//        Point point3 = new Point(0,10);
//        Point point4 = new Point(0,5);
//        Point points[] = { point1,point2,point3,point4};
//        //closestPoints.ClosestPoints(points,points.length);
//        double a = closestPoints.ClosestPoints(points,0,3);
//        System.out.print(a);
        KMP kmp = new KMP();
       char a[]  = {'a','b','c','f','p','o'};
        char b[] = {'c','f','\0'};
        String a1 = "acdfe";
        String b1 = "fe";
        System .out .print(kmp.indexOf(a1,b1));


    }
}
