package com.company5;

/**
 * Created by asus on 2016/12/20.
 */
public class CoinProblemBasicTest {
    public int[] getD() {
        return d;
    }

    public void setD(int[] d) {
        this.d = d;
    }

    private int[] d; // ������
    private int[] coins = {1, 3, 5}; // Ӳ������
    public  void d_func(int i, int num) {
        if (i == 0) {
            d[i] = 0;
            d_func(i + 1, num);
        } else {
            int min = 9999999; // ��ʼ��һ���ܴ����ֵ�����������ó��Ľ���������ʱ��˵���ղ�������
            for (int coin : coins) {
                if (i >= coin && d[i - coin] + 1 < min) {
                    min = d[i - coin] + 1;
                }
            }
            d[i] = min;

            if (i < num) {
                d_func(i + 1, num);
            }
        }
    }
}