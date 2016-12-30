package com.Tsp;

/**
 * Created by asus on 2016/12/30.
 */

public class TSP3 {                     //���ݷ�
    public  static  void  main(String arg[])
    {
        TSP3 tsp3 = new TSP3();
        tsp3.solve();
        System.out.println(tsp3.getMinLen());
    }

    private static int N = 4;

    private int cl; //��ǰ·���ĳ���
    private int fl; //��ǰֻ�������·������

    private int weight[][] = {                          //���۾���
//            {0, 30, 6, 5},
//            {30, 0, 4, 10},
//            {6, 4, 0, 20},
//            {5, 10, 20, 0}
            {0, 13, 8, 9},
            {13, 0, 3, 15},
            {8, 3, 0, 20},
            {9, 15, 20, 0}
    };
    private int x[] = new int[4];
    private int bestX[] = new int[4];
    public int[] getBestX() {
        return bestX;
    }

    public int getMinLen(){
        return fl;
    }
    /**
     * �жϵ�k�����Ƿ�ͬ��ǰk-1����
     * @param k
     * @return bool
     */

    private boolean nextValue(int k){                   //�ӽڵ㲻Ӧ���ڸ��ڵ���ֹ����ù������ڽ���ʱѰ����һ���ڵ�
        int i = 0;
        while(i < k){
            if(x[k] == x[i]){
                return false;
            }
            i += 1;
        }
        return true;
    }

    /**
     * ��k��·��ѡ��
     * @param k
     */
    private void backUp(int k){
        if(k==N-1){
            for (int j=1;j<=N;j++){
                x[k] = Math.floorMod(x[k]+1, N);
                if(nextValue(k) && cl + weight[x[k-1]][x[k]] + weight[x[k]][0] < fl) {//������·��,�������Ž�
                    fl = cl + weight[x[k - 1]][x[k]] + weight[x[k]][0];
                    for (int i = 0; i < N; i++) {
                        bestX[i] = x[i];
                    }
                }
            }
        }else{
            for(int j=1; j<=N; j++){
                x[k] = Math.floorMod(x[k]+1, N);
                if(nextValue(k) && cl+weight[x[k-1]][x[k]] <= fl){
                    //��·����
                    cl += weight[x[k-1]][x[k]];
                    backUp(k+1);
                    cl -= weight[x[k-1]][x[k]];
                }
            }

        }
    }
    public void solve(){
        int k = 1; //��0�������ǹ̶���,�ӵ�һ�����㿪ʼѡ��
        cl = 0;
        fl = Integer.MAX_VALUE;
        backUp(k);
    }
}

