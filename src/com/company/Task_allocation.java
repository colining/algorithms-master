package com.company;

import algorithms.Task_allocationSolves;

/**
 * Created by asus on 2016/11/25.
 */
public class Task_allocation {
    public static void  main(String arg[])
    {
        int C[][]= {{1,2},{1,2}};
        Task_allocationSolves task_allocationSolves = new Task_allocationSolves();
        int a = task_allocationSolves.Task_allocationSolves(C);
        System.out.println(a);
    }
}
