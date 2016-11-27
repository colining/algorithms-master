package com.company;

import algorithms.Permutation;
import algorithms.TspSolves;
import model.Mynode;
import model.Node_side;

/**
 * Created by asus on 2016/11/25.
 */
public class tsp {
    public static void main(String arg[]){

    Mynode a =new Mynode(1);
    Mynode b= new Mynode(2);
    Mynode c = new Mynode(3);
    Mynode d = new Mynode(4);
    Node_side ab = new Node_side(a, b, 4);
    Node_side ac = new Node_side(a, c, 5);
    Node_side ad = new Node_side(a, d, 6);
    Node_side bc = new Node_side(b, c, 6);
    Node_side bd = new Node_side(b, d, 10);
    Node_side cd = new Node_side(c, d, 2);
    Node_side node_side[] = {ab, ac, ad, bc, bd, cd};
        Mynode mynodes [] = {a,b,c,d};
        TspSolves tspSolves = new TspSolves();
        tspSolves.permulation(node_side,mynodes,0,4);

        System.out.println(tspSolves.getMin());
    }

}
