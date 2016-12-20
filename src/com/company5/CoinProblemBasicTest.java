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

    private int[] d; // 储存结果
    private int[] coins = {1, 3, 5}; // 硬币种类
    public  void d_func(int i, int num) {
        if (i == 0) {
            d[i] = 0;
            d_func(i + 1, num);
        } else {
            int min = 9999999; // 初始化一个很大的数值。当最后如果得出的结果是这个数时，说明凑不出来。
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