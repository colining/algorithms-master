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
                int d[][] = new int[n][len];  //结果矩阵
                int myarc[][] = new int[n][n];
                for (int i = 0;i<n;i++)
                {
                    int k=0;
                    for (int j = 0;j<n;j++)
                    {
                       // System.out.print("k="+k+"\n");
                        if (i==j)
                        {
                            myarc[i][j]=0;
                        }
                        else
                        {
                            myarc[i][j]=a[i][k];
                            k++;
                        }
                        System.out.print(myarc[i][j]+"" );
                    }
                    System.out.println();
                }

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
//               for (int i=1;i<v.length;i++) {
//                       for (int j = 0; j <v[i].length; j++) {
//                               System.out.print(v[i][j]);
//                       }
//                       System.out.println();
//               }

//               for(int i =1;i<n;i++)
//               {
//
//               }

            for (int i = 0 ; i<n;i++)
            {
                d[i][0]= myarc[i][0];
            }

                for (int j=1;j<v.length;j++)        //数组一维
                {
                    for (int i = 0;i<n;i++)
                    {
                    int j1 = 0;
                    for (int k = 0; k < v[j].length; k++)     //数组二维大小，遍历每一个值
                    {
                        if (v[j][k] == i)              //当顶点与子集冲突时，跳出
                            break;
                        if (k == v[j].length - 1) {
                            j1 = 1;
                        }

                    }
                    int min = 100;
                    if (j1 == 1) {

                        int jj=j;
                        for (int i1 = 0; i1 < v[j].length; i1++) {  //对于每一个数组元素计算长度
                            int myk = v[j][i1];
                            if (v[j].length%2==1)
                            {
                                if (myarc[i][myk] + d[myk][j-myk] < min) {
                                min = myarc[i][myk] + d[myk][j-myk];


                                }
                            }
                            else
                            {
                                if (myarc[i][myk] + d[myk][j-myk-1] < min) {
                                    min = myarc[i][myk] + d[myk][j-myk-1];
                                }
                            }
                        }

//                        System.out.print(min + " ");
//                        System.out.println();
                    }
                    d[i][j] = min;
                }
            }
            System.out.print(d[0][len-1]);
                return 0;

        }
}
