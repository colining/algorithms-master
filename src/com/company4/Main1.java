package com.company4;

import java.util.Scanner;

/**
 * Created by asus on 2016/12/18.
 */
public class Main1 {
    int n=0;
    public static void main(String arg[]) {
               // int a[][] =  {{3,1,5,8},{3,6,7,9},{1,6,4,2},{5,7,4,3},{8,9,2,3}};//{{3, 6, 7}, {5, 2, 3}, {6, 4, 2}, {3, 7, 5}};//
                //int test[] = {0, 1, 2, 3};

                Main1 tsp = new Main1();
                Scanner scanner = new Scanner(System.in);
        //System.out.println("请输入顶点数目");
                int n = scanner.nextInt();
                int a[][]=new int[n][n-1];
                for (int i=0;i<n;i++) {
                   // System.out.println("请输入该层代价");
                    for (int j = 0; j < n - 1; j++) {
                        a[i][j] = scanner.nextInt();
                    }
                }
                tsp.Tsp(a);
        }
        public int Tsp(int a[][]) {
                String str ="";
                 n = a[0].length + 1;
                int len = (int) Math.pow(2, n - 1);
                int v[][] = new int[len][];
                int d[][] = new int[n][len];  //结果矩阵
                int myarc[][] = new int[n][n];
                for (int i = 0;i<n;i++)     //矩阵重构 补充0
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
                        //System.out.print(myarc[i][j]+"" );
                    }
                    //System.out.println();
                }

                int test[] = new int[n-1];
                for (int i = 0; i <n-1; i++) {                   //节点从0到n-1
                        test[i] = i+1;
                }
                int testcopy[] =new int[n];
                testcopy[0]=0;
            for (int i=1;i<=n-1;i++)
            {

                testcopy[i]=count(i-1,n-1)+testcopy[i-1];
                //System.out.println(testcopy[i]);

            }
            int test1[] = new int[len];
            test1 = testcopy.clone();

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
                                //System.out.print("该组合数目为"+j1+" \n");
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
                              // System.out.print(v[i][j]);
                       }
                       //System.out.println();
               }
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
                    int min = 10000;
                    if (j1 == 1) {

                        int jj=j;
                        for (int i1 = 0; i1 < v[j].length; i1++) {  //对于每一个数组元素计算长度
                            int myk = v[j][i1];
                            int mytest = find(j,myk,v,testcopy);
                            if (myarc[i][myk]+d[myk][mytest]<min)
                            {
                                min=myarc[i][myk]+d[myk][mytest];
                            }
//                            if (v[j].length%2==1)
//                            {
//                                if (myarc[i][myk] + d[myk][j-myk] < min) {
//                                min = myarc[i][myk] + d[myk][j-myk];
//
//
//                                }
//                            }
//                            else
//                            {
//                                if (myarc[i][myk] + d[myk][j-myk-1] < min) {
//                                    min = myarc[i][myk] + d[myk][j-myk-1];
//                                }
//                            }
                        }

//                        System.out.print(min + " ");
//                        System.out.println();
                    }
                    d[i][j] = min;
                }
            }
            System.out.println(d[0][len-1]);

//            int mytest = find(7,1,v,testcopy);
//            System.out.println(mytest);
                return 0;

        }
        public  int find(int i,int j,int v[][],int test1[])
        {
            int a = 0;
            boolean flag=true;
            for (int i1 =0;i1<test1.length;i1++)
            {
                if (test1[i1]>i) {
                    a=i1-2;
                    break;
                }
                if (test1[i1]==i)
                {
                    a=i1-1;
                    break;
                }
            }
            if (a<=0)
                return 0;
            for (int i1 = 0;i1<v[i].length;i1++)
            {
                if (j==v[i][i1])
                {
                    flag=false;
                    break;
                }
            }
            if (flag)
            {
                return 0;
            }
            int b = 0;
            int sum=0;
            int sum1=0;
            for (int j1=0;j1<v[i].length;j1++)
            {
                sum+=v[i][j1];
            }

            for (int i1=test1[a];i1<test1[a+1];i1++)
            {
                sum1=0;
                for (int j1 = 0;j1<v[i1].length;j1++)
                {
                    sum1 += v[i1][j1];
                }
                if (sum1 +j==sum)
                {
                    b=i1;
                    break;
                }
            }

            return  b;
        }
   public  int count(int o,int n)
   {
       if (o==0)
           return 1;
       int a=1;
       for (int i=n,count=0;count<o;i--,count++)
       {
           //System.out.println(i);
           a*=i;
       }
       int b=1;
       for (;o>0;o--)
       {
           b*=o;
       }

       //System.out.println("组合数为"+a+" "+b);
       return a/b;
   }
}
