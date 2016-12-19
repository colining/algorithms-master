package com.company4;

import java.util.Scanner;

/**
 * Created by asus on 2016/12/18.
 */
public class TSPDemo {
        public static void main(String arg[]) {
                int a[][] = {{3, 6, 7}, {5, 2, 3}, {6, 4, 2}, {3, 7, 5}};
                int test[] = {0, 1, 2, 3};
                TSPDemo tsp = new TSPDemo();
                tsp.Tsp(a);

        }
        public int Tsp(int a[][]) {
                int n = a[0].length + 1;
                int len = (int) Math.pow(2, n - 1);
                int v[][] = new int[len][];
                int test[] = new int[n-1];
                for (int i = 0; i <n-1; i++) {                   //节点从0到n-1
                        test[i] = i+1;

                }
                int test1[] =new int[len];
                for (int i = 1 ;i <len;i++)
                {
                        test1[i]=3*(i-1)+1;

                }

                int nCnt = test.length;
                int nBit = (0xFFFFFFFF >>> (32 - nCnt));
                        for (int i = 1; i <= nBit; i++) {
                                int  arr1[]=new int[n];
                                int j1=0;                       //该组合的数字个数
                                for (int j = 0; j < nCnt; j++) {

                                        if ((i << (31 - j)) >> 31 == -1) {
                                              // System.out.print(test[j]+" ");
                                                arr1[j1++]=test[j];
                                        }
                                }
                                System.out.print("该组合数目为"+j1+" \n");
                                if (j1!=0)
                                {
                                int k = test1[j1]++;            //取出组合应赋予的v[i]上
                                        v[k]= new int[j1];
                                for (int i1=0;i1<j1;i1++)
                                {
                                        v[k][i1]=arr1[i1];
                                }
//                                for (int i2 = 0;i2<v[k].length;i2++)
//                                {
//                                        System.out.println(v[k][i2]);
//                                }
//                                System.out.println(" 将其添加到的位置是"+(test1[j1]-1));
                               // System.out.println("\n");
                        }
                        }
               for (int i=1;i<v.length;i++) {
                       for (int j = 0; j <v[i].length; j++) {
                               System.out.print(v[i][j]);
                       }
                       System.out.println();
               }
               for(int i =1;i<n;i++)
               {

               }
                return 0;

        }
}
