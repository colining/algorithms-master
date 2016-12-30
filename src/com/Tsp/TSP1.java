package com.Tsp;

import java.time.temporal.Temporal;
import java.util.Scanner;

/**
 * Created by asus on 2016/12/30.
 */
public class TSP1 {
    public  static  void  main(String arg[])
    {
        int n,temp,minDis;
        Scanner scanner = new Scanner(System.in);
        n=scanner.nextInt();
        int dis[][]= new int[n][n];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(j!=i)
                {
                    temp =scanner.nextInt();
                    dis[i][j]=temp;
                }
                else
                {
                    dis[i][j]=1000;
                }
               // System.out.println(dis[i][j]);
            }
        }
        TSP1 tsp1 = new TSP1();
        tsp1.TSP1(dis);
    }

    public  void  TSP1(int dis[][])
    {
        int temp;
        int n = dis.length;
        int minDis;
        int d[][] = new int[n][(int) Math.pow(2,n-1)];                                 //2的n-1次方
        for(int i=1; i<n; i++)
        {
            d[i][0]=dis[i][0];
        }

        for(int j=1; j<(int)Math.pow(2,n-1); j++)
        {
            for(int i=1; i<n; i++)   //j用二进制表示的城市集合
            {
                if(((int)(Math.pow(2,i-1))&j)==0)          //i不在j表示的城市集合中
                {

                    minDis=60000;
                    for(int k=1; k<n; k++)
                    {
                        if(((int)(Math.pow(2,k-1))&j)!=0)   //k表示的城市在j表示的城市集合中
                        {

                            temp=dis[i][k]+d[k][j-((int)(Math.pow(2,k-1)))];
                            if(temp<minDis)
                            {
                                minDis=temp;   //所有k中最小的距离
                            }
                        }
                    }
                    d[i][j]=minDis;
                }
            }
        }
        minDis=60000;
        for(int k=1; k<n; k++)
        {
            temp=dis[0][k]+d[k][(((int)Math.pow(2,n-1))-1)-((int)(Math.pow(2,k-1)))];
            if(minDis>temp)
            {
                minDis=temp;
            }
        }
        d[0][((int)Math.pow(2,n-1))-1]=minDis;
        System.out.println(d[0][((int) Math.pow(2, n - 1)) - 1]);

    }

}
