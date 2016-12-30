package com.company6;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by asus on 2016/12/23.
 */
public class PrimeCircle {
    int n ;
//    boolean flag = true;
    public  static  void  main(String arg[])
    {
        PrimeCircle primeCircle = new PrimeCircle();
        Scanner cin = new Scanner(System.in);
        ArrayList list = new ArrayList();
        int i = 0;
        while(cin.hasNextInt()) {
            list.add( cin.nextInt());
            i++;
        }
        for (i=0;i<list.size();i++)
        {
            System.out.println("Case "+(i+1)+":");
            primeCircle.PrimeCircle((int)list.get(i));
            if(i!=list.size()-1)System.out.println();
        }

    }

    void  PrimeCircle(int n)    //输入为n，素数环从1到n；
    {
        if (n==1) {                 //防止输入为一，其实没有意义啦；
            System.out.println(1);
            return;
        }

        int i ,k ;
        this.n = n;
        int a[] = new int[n];
        for ( i =0; i <n ;i++)      //初始化数组a，用来储存素数环答案
        {
            a[i]=0;
        }
        a[0]= 1 ; k =1;             //指定第一个位置为1；凡事总有开头的嘛
            while (k>=1)
            {
                a[k] = a[k] +1;
                while (a[k]<=n) {
                    if (Check(k, a) == 1)  //如果满足要求，就跳出
                        break;
                    else
                        a[k] = a[k] + 1;       //不满足，就试验下一个数
                }

                if (a[k]<= n &&k==n-1)          //如果最后一个也成立，就输出啦
                {
                    for (i=0;i<n-1 ;i++)
                    System.out.print(a[i]+" ");
                    System.out.print(a[n-1]);           //这样写会在最后输出换行，而不是空格
                    System.out.println();
                }
                if (a[k]<=n && k <n - 1)                //如果没有完成，就继续下一个位置
                    k+=1;
                else
                    a[k--]=0;                           //说明这个树枝无法填写了，所以回到父节点；
            }
    }

    int Prime( int x)       //判断素数，素数返回1，合数返回0；
    {
        int i , n ;
        n = (int) Math.sqrt(x);
        for (  i = 2 ; i <=n ; i++)
        {
            if (x%i==0)
                return 0;

        }
        return 1;
    }
    int Check (int k,int a[])
    {
        int flag = 0 ;
        for (int i =0;i<k;i++)          //检查是否重复
            if (a[i] == a[k])
                return  0;

        flag = Prime(a[k]+a[k-1]);  //检验与相邻之和是否是素数
        if (flag ==1&&k ==n-1)          //如果是最后一个，需要检查与开始值得和
            flag = Prime(a[k]+a[0]);
        return flag;
    }
}
