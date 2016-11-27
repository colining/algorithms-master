package com.company;

/**
 * Created by asus on 2016/11/25.
 */
import algorithms.KnapsackSolves;

import java.util.Scanner;
public class KnapsackDemo {
    public static void main(String[] args) {

        int m;//��Ʒ������
        int capacity;//����������
        int wb=0;//��ʼ������������
        int vb=0;//��ʼ�������ļ�ֵ
        KnapsackSolves s=new KnapsackSolves();
        Scanner sc=new Scanner(System.in);
        System.out.print("��������Ʒ��������");
        m=sc.nextInt();
        System.out.print("�����뱳����������");
        capacity=sc.nextInt();
        int weight[]=new int[m];//������¼ÿ����Ʒ������
        int value[]=new int[m];//������¼ÿ����Ʒ�ļ�ֵ
        for(int i=0;i<m;i++)
        {
            System.out.print("��������Ʒ"+i+"��������");
            weight[i]=sc.nextInt();
            System.out.print("��������Ʒ"+i+"�ļ�ֵ��");
            value[i]=sc.nextInt();
        }
        int MaxValue[]=new int[(int)Math.pow(2, m)];
        System.out.println("�����������£�");
        for (int i = 0; i <Math.pow(2, m); i++)
        {
            for (int j =0; j<m; j++)
            {
                if(s.Subset(m)[i][j]==1)
                {
                    wb+=weight[j]*s.Subset(m)[i][j];
                    vb+=value[j];
                    System.out.print("��Ʒ:"+j+"");
                }
            }


            if(wb<=capacity)
            {
                MaxValue[i]=wb;
                System.out.println("------"+"����"+i+":�ܼ�ֵΪ��"+vb+" "+"������Ϊ��"+wb);
            }
            else
            {
                System.out.println("------"+"����"+i+":��������������");
            }

            wb=0;
            vb=0;
        }
        System.out.println("������װ����������Ϊ��"+s.MaxValue(MaxValue));
    }
}