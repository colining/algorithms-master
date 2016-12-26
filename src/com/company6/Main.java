package com.company6;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by asus on 2016/12/23.
 */
public class Main {
   // int a[];
    int n ;
    boolean flag = true;
    public  static  void  main(String arg[])
    {
        Main primeCircle = new Main();
        Scanner cin = new Scanner(System.in);
        //int b[];
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

    void  PrimeCircle(int n)
    {
        if (n==1) {
            System.out.println(1);
            return;
        }

        int i ,k ;
        this.n = n;
        int a[] = new int[n];
        for ( i =0; i <n ;i++)
        {
            a[i]=0;
        }
        a[0]= 1 ; k =1;
            while (k>=1)
            {
                a[k] = a[k] +1;
                while (a[k]<=n)
                    if (Check(k,a)==1)
                        break;
                else
                    a[k] =a[k]+1;

                if (a[k]<= n &&k==n-1)
                {
//                    if (flag==true)
//                    System.out.println("Case "+(j)+":");
//                    flag = false;
                    for (i=0;i<n-1 ;i++)
                    System.out.print(a[i]+" ");
                    System.out.print(a[n-1]);
                    System.out.println();

                }
                if (a[k]<=n && k <n - 1)
                    k+=1;
                else
                    a[k--]=0;
            }
            //flag = true;
    }

    int Prime( int x)
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
        for (int i =0;i<k;i++)
            if (a[i] == a[k])
                return  0;
        flag = Prime(a[k]+a[k-1]);
        if (flag ==1&&k ==n-1)
            flag = Prime(a[k]+a[0]);
        return flag;
    }
}
