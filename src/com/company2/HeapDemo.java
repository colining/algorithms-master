package com.company2;

import algorithms2.HeapSort;

/**
 * Created by asus on 2016/11/30.
 */
public class HeapDemo {


    public static void main(String args[]){
        HeapSort hs = new HeapSort();
        int[] array = {87,45,78,32,17,65,53,9,122};
        System.out.print("��������ѣ�");
        hs.toString(hs.buildMaxHeap(array));
        System.out.print("\n"+"ɾ���Ѷ�Ԫ�أ�");
        hs.toString(hs.deleteMax(array));
        System.out.print("\n"+"����Ԫ��63:");
        hs.toString(hs.insertData(array, 63));
        System.out.print("\n"+"���������");
        hs.toString(hs.heapSort(array));
        hs.toString(hs.deleteDate(array,3));
    }
}
