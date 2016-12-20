package com.company5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2016/12/20.
 */
public class CoinChange {
    /**
     * 获取找零硬币个数
     * @param coinValue 硬币的面值
     * @param totalValue 需要找零的钱数
     * @return
     */
    public int coinNum(int[] coinValue,int totalValue){
        List<Integer> coins=new ArrayList<Integer>();
        coins.add(0);
        for(int i=1;i<=totalValue;i++){
            int coin=nearestCoin(i,coinValue);
            int coinNum=coins.get(i-coin)+1;
            coins.add(coinNum);
        }
        return coins.get(totalValue);
    }
    /**
     * 获取最接近找零钱数的硬币面值
     */
    private int nearestCoin(int value,int[] coinValues){
        int res=0;
        int nearest=Integer.MAX_VALUE;
        for(int coinValue:coinValues){
            if(coinValue<=value){
                int distance=value-coinValue;
                if(distance<nearest){
                    nearest=distance;
                    res=coinValue;
                }
            }
        }
        return res;
    }
}