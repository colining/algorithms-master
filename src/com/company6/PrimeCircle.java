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

    void  PrimeCircle(int n)    //����Ϊn����������1��n��
    {
        if (n==1) {                 //��ֹ����Ϊһ����ʵû����������
            System.out.println(1);
            return;
        }

        int i ,k ;
        this.n = n;
        int a[] = new int[n];
        for ( i =0; i <n ;i++)      //��ʼ������a������������������
        {
            a[i]=0;
        }
        a[0]= 1 ; k =1;             //ָ����һ��λ��Ϊ1���������п�ͷ����
            while (k>=1)
            {
                a[k] = a[k] +1;
                while (a[k]<=n) {
                    if (Check(k, a) == 1)  //�������Ҫ�󣬾�����
                        break;
                    else
                        a[k] = a[k] + 1;       //�����㣬��������һ����
                }

                if (a[k]<= n &&k==n-1)          //������һ��Ҳ�������������
                {
                    for (i=0;i<n-1 ;i++)
                    System.out.print(a[i]+" ");
                    System.out.print(a[n-1]);           //����д�������������У������ǿո�
                    System.out.println();
                }
                if (a[k]<=n && k <n - 1)                //���û����ɣ��ͼ�����һ��λ��
                    k+=1;
                else
                    a[k--]=0;                           //˵�������֦�޷���д�ˣ����Իص����ڵ㣻
            }
    }

    int Prime( int x)       //�ж���������������1����������0��
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
        for (int i =0;i<k;i++)          //����Ƿ��ظ�
            if (a[i] == a[k])
                return  0;

        flag = Prime(a[k]+a[k-1]);  //����������֮���Ƿ�������
        if (flag ==1&&k ==n-1)          //��������һ������Ҫ����뿪ʼֵ�ú�
            flag = Prime(a[k]+a[0]);
        return flag;
    }
}
