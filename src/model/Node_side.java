package model;

/**
 * Created by asus on 2016/11/25.
 */
public class Node_side {
    private int side;
    private Mynode a;
    private Mynode b;

    public Node_side() {
    }


    public Mynode getA() {
        return a;
    }

    public Mynode getB() {
        return b;
    }


    public   int getSide() {
        return side;
    }



    public Node_side(Mynode a, Mynode b, int side) {
        this.a = a;
        this.b = b;
        this.side = side;
    }
}
