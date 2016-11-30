package com.company;

import algorithms.ClosestPoints;
import model.Point;

/**
 * Created by asus on 2016/11/25.
 */
public class PointDemo {
    public static void main(String[] args) {
        ClosestPoints closestPoints = new ClosestPoints();
        Point point1 = new Point(0, 0);
        Point point2 = new Point(0, 2);
        Point point3 = new Point(0, 10);
        Point point4 = new Point(0, 5);
        Point points[] = {point1, point2, point3, point4};
        //closestPoints.ClosestPoints(points,points.length);
        //double a = closestPoints.ClosestPoints(points, 0, 3);   //分治
        //System.out.print("最近点对距离为"+a);
        double a = closestPoints .ClosestPoints(points,4);  //蛮力法


    }
}
