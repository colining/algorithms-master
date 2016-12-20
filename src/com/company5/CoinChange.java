package com.company5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2016/12/20.
 */
public class CoinChange {
    /**
     * ��ȡ����Ӳ�Ҹ���
     * @param coinValue Ӳ�ҵ���ֵ
     * @param totalValue ��Ҫ�����Ǯ��
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
     * ��ȡ��ӽ�����Ǯ����Ӳ����ֵ
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