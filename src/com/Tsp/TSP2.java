package com.Tsp;

/**
 * Created by asus on 2016/12/30.
 */
public class TSP2 {                                         //贪心法
    public  static  void  main(String arg[])
    {
        int arc[][] = {{1000,3,3,2,6},{3,1000,7,3,2},{3,7,1000,2,5},{2,3,2,1000,3},{6,2,5,3,1000}};
        TSP2 tsp2 = new TSP2();
        System.out.println(tsp2.TSP2(arc, 0));

    }

    int TSP2 (int arc[][],int w)            //arc是代价矩阵，w是顶点，从0开始；
    {
        int n = arc.length;                 //n相当于顶点个数
        int edgeCount = 0 ;
        int TSPlength = 0 ;                 //哈密顿回路长度
         int min , u , v=0;
        int flag[] = new int[n];            //路径上顶点的先后
        u = w; flag [w] = 1;
        while (edgeCount<n-1)               //边数小于n-1
        {
            min= 100;
            for (int j = 0 ;j<n ; j ++)     //求得arc[u]的最小值，即当前顶点的临近顶点最小值
            {
                if ((flag[j] == 0 )&&(arc[u][j]!=0)&&(arc[u][j]<min))       //取得最小值
                {
                    v= j ; min = arc[u][j];
                }
            }
            TSPlength+=arc[u][v];       //回路长度加上刚才的最小值
            flag[v]= 1;                 //将该顶点从剩余顶点排出
            edgeCount++;                //已排列多了一个
            System.out.println(u+"-->"+v);      //输出
            u=v;
        }
        System.out.println(v+"-->"+w);          //最后输出回路终点到达起始点
        return (TSPlength+arc[u][w]);

    }
}
