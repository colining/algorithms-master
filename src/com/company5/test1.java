package com.company5;

import java.util.Scanner;

/**
 * Created by asus on 2016/12/20.
 */
public class test1 {
    double money [] = {50.0,20.0,10.0,5.0,1.0,0.5,0.1};
    int n = 7;
    public static void  main(String arg[])
    {

        double change;
        Scanner scanner = new Scanner(System.in);
        System.out.println("你想找多少钱呢?");
        change = scanner.nextDouble();
        test1 test1 = new test1();
        test1.Change(change);
//        CoinChange coinChange=new CoinChange();
//        int res=coinChange.coinNum(new int[]{1,2,3,5,11},81);
//        System.out.println(res);


    }
    public  void Change(double change)
    {
        for (int i = 0 ; i < n;i++)
        {
            double change1 =0.0;
            int num = 0;
            //System.out.println(money[6] * 3);
            for (int j =1; money[i]*j<=change+0.01;j++)
            {
                num = j;
                change1+=money[i];
            }
            if (num!=0)
            {
                System.out.println("应找回"+money[i]+"元"+num+"张");
            }
            change-=change1;
            if(change == 0 )
                break;
        }
    }
}
