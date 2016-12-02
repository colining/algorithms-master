package com.company;

import algorithms.ConvexHull;

/**
 * Created by asus on 2016/12/2.
 */
public class ConvexHullDemo {
    public  static  void  main(String arg[]) {
        int x[] = {1, 5, 6, 8, 4, 2, 1};
        int y[] = {5, 6, 80, 2, 5, 6, 9};
        ConvexHull convexHull = new ConvexHull();
        convexHull .ConvexHull(x,y,6);
    }
}
