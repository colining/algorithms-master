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
        //System.out.print("������ʵ���ĸ���\n");
        int a = in.nextInt();
        for (int i = 0; i < a; i++) {
            //System.out.print("�����������߶�\n");
            int h = in.nextInt();
            int [][]array1 = new int[h][h];
            for (int i1 = 0; i1 < h; i1++) {
               // System.out.print("������"+i1+"��Ľڵ�\n");
                for (int i2 = 0; i2 <=i1; i2++) {
                    array1[i1][i2]=in.nextInt();
                }
            }
            System.out.print(tower.DataTower(array1)+"\n");
        }

    }
    int DataTower (int d[][])
    {
        int n = d.length;               //һά����
        int len = d[0].length;          //��ά����
        int [][] maxAdd = new int [n][len];
        int [][] path = new int [n][len];
        int j ;
        for ( j = 0 ; j <n;j++)                     //��maxAdd������һ�㸳ֵΪd ����Ϊһ��
            maxAdd[n-1][j] = d[n-1][j];
        for ( int i=n-2;i>=0;i--)                       //����ÿһ����˵���Ե�����
        {
            for (j = 0 ; j <= i ;j++)               //ÿһ��ĸ����ڵ�
            {
                if (maxAdd[i+1][j] >maxAdd[i+1][j+1])       //�����ӽڵ�˭�󣬸��ڵ�ͼ�˭
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
