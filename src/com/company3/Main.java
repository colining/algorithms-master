package com.company3;



/**
 * Created by asus on 2016/12/9.
 */
import java.util.Scanner;
public class Main {
    public  static  void  main(String arg[])
    {
        Scanner in = new Scanner(System.in);
        int arr[];
        //System.out.print("输入数字个数");
        int num = in.nextInt();
        arr = new int[num];
        //System.out.print("输入数字");
        for (int i = 0; i < num; i++) {
            arr[i]= in.nextInt();
        }
        Main maxsub = new Main();
        System.out.print(maxsub.MaxSub(arr));
    }
    int MaxSub( int a[])
    {

        int bmax=0;
        int b = 0;
        for (int i =0; i < a.length; i ++)
        {
            if (b>0)
            {
                b+=a[i];
            }
            else {
                b = a[i];
            }
            if (b>bmax)
                bmax=b;
        }
        return  bmax ;

    }
}
