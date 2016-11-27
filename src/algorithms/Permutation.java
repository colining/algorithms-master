package algorithms;

import model.Mynode;
import model.Node_side;

/**
 * Created by asus on 2016/11/25.
 */
public class Permutation {
    public Permutation() {
    }

    public static void permulation(Mynode []list, int start, int length) {
        int i;
        if (start == length) {
            for (i = 0; i < length; i++)
                System.out.print(list[i] + " ");
            System.out.println();
        } else {
            for (i = start; i < length; i++) {
                swap(list, start, i);
                permulation(list, start + 1, length);
                swap(list, start, i);
            }
        }
    }
    public static void swap(Mynode [] list, int start, int i) {
        Mynode temp;
        temp = list[start];
        list[start] = list[i];
        list[i] = temp;
    }
}


