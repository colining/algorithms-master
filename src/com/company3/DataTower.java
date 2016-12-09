package com.company3;



/**
 * Created by asus on 2016/12/9.
 */
import java.util.Scanner;
public class DataTower {

    public  static void  main (String arg[])
    {

      DataTower tower= new DataTower();
        Scanner in = new Scanner(System.in);
        //System.out.print("请输入实例的个数\n");
        int a = in.nextInt();
        for (int i = 0; i < a; i++) {
            //System.out.print("请输入数塔高度\n");
            int h = in.nextInt();
            int [][]array1 = new int[h][h];
            for (int i1 = 0; i1 < h; i1++) {
               // System.out.print("请输入"+i1+"层的节点\n");
                for (int i2 = 0; i2 <=i1; i2++) {
                    array1[i1][i2]=in.nextInt();
                }
            }
            System.out.print(tower.DataTower(array1)+"\n");
        }

    }
    int DataTower (int d[][])
    {
        int n = d.length;               //一维长度
        int len = d[0].length;          //二维长度
        int [][] maxAdd = new int [n][len];
        int [][] path = new int [n][len];
        int j ;
        for ( j = 0 ; j <n;j++)                     //将maxAdd最下面一层赋值为d ，因为一样
            maxAdd[n-1][j] = d[n-1][j];
        for ( int i=n-2;i>=0;i--)                       //对于每一层来说，自底向上
        {
            for (j = 0 ; j <= i ;j++)               //每一层的各个节点
            {
                if (maxAdd[i+1][j] >maxAdd[i+1][j+1])       //左右子节点谁大，父节点就加谁
                {
                    maxAdd[i][j] = d[i][j]+maxAdd[i+1][j];
                    path [i][j] = j ;
                }
                else
                {
                    maxAdd[i][j] = d[i][j]+maxAdd[i+1][j+1];
                    path[i][j] = j+1;
                }
            }
        }
        return  maxAdd[0][0];
    }
}
