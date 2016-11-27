package algorithms;

import model.Mynode;
import model.Node_side;


/**
 * Created by asus on 2016/11/25.
 */
public class TspSolves {

    private  Mynode[] listtest;
    private  int test=0;

    public int getMin() {
        return min;
    }

    private int min=100;

    public int getTest() {
        return test;
    }

    public Mynode[] getListtest() {
        return listtest;
    }



    public TspSolves() {
    }

    public void permulation(Node_side[] node_side,Mynode []list, int start, int length) {
        int i;
        if (start == length) {
            test=0;
            for (int i1 = 0; i1 < list.length; i1++) {
                System.out.print(list[i1].getTest());
            }
            System.out.println();
            for (i = 0; i < length-1; i++) {
                for (int j = 0; j < node_side.length; j++)
                {

                    if (list[i] == node_side[j].getA() && list[i + 1] == node_side[j].getB() || list[i + 1] == node_side[j].getA() && list[i] == node_side[j].getB()) {
                        System.out.print(""+list[i].getTest()+"->"+list[i+1].getTest()+"¾àÀëÎª"+node_side[j].getSide()+" ");
                        test += node_side[j].getSide();
                    }

                }
            }

            if (test<min)
            {
                min=test;
                listtest = list;
               }


        } else {
            for (i = start; i < length; i++) {
                swap(list, start, i);
                permulation(node_side ,list, start + 1,length);
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
