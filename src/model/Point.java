package model;

/**
 * Created by asus on 2016/11/24.
 */
public class Point {
    public Point() {
        this.x = 0;
        this.y=0;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    private  double x;
    private  double y ;

    public Point(int x, int y ) {
    this.x=x;
        this.y=y;
    }

}
