package com.Tsp;

/**
 * Created by asus on 2016/12/30.
 */
public class TSP2 {                                         //̰�ķ�
    public  static  void  main(String arg[])
    {
        int arc[][] = {{1000,3,3,2,6},{3,1000,7,3,2},{3,7,1000,2,5},{2,3,2,1000,3},{6,2,5,3,1000}};
        TSP2 tsp2 = new TSP2();
        System.out.println(tsp2.TSP2(arc, 0));

    }

    int TSP2 (int arc[][],int w)            //arc�Ǵ��۾���w�Ƕ��㣬��0��ʼ��
    {
        int n = arc.length;                 //n�൱�ڶ������
        int edgeCount = 0 ;
        int TSPlength = 0 ;                 //���ܶٻ�·����
         int min , u , v=0;
        int flag[] = new int[n];            //·���϶�����Ⱥ�
        u = w; flag [w] = 1;
        while (edgeCount<n-1)               //����С��n-1
        {
            min= 100;
            for (int j = 0 ;j<n ; j ++)     //���arc[u]����Сֵ������ǰ������ٽ�������Сֵ
            {
                if ((flag[j] == 0 )&&(arc[u][j]!=0)&&(arc[u][j]<min))       //ȡ����Сֵ
                {
                    v= j ; min = arc[u][j];
                }
            }
            TSPlength+=arc[u][v];       //��·���ȼ��ϸղŵ���Сֵ
            flag[v]= 1;                 //���ö����ʣ�ඥ���ų�
            edgeCount++;                //�����ж���һ��
            System.out.println(u+"-->"+v);      //���
            u=v;
        }
        System.out.println(v+"-->"+w);          //��������·�յ㵽����ʼ��
        return (TSPlength+arc[u][w]);

    }
}
