package com.company2;

import java.util.Random;

import static algorithms2.CoinSolves.compareTo;

/**
 * Created by asus on 2016/12/2.
 */
public class CoinDemo {
    public static  void  main (String arg[]) {
        int[] coins = {2, 2, 2, 3, 2, 2, 2, 2};

        int[] left = new int[4];
        int[] right = new int[4];
        int flag = 0;
        int location = compareTo(coins, left, right);
        for (int i = 0; i < coins.length; i++) {
            flag++;
            if (coins[i] == location) {
                System.out.println("µÚ" + flag + "Ã¶Ó²±ÒÎª¼Ù±Ò£¡");
            }
        }
    }
}
