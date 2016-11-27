package algorithms;

import model.Point;

/**
 * Created by asus on 2016/11/24.
 */
public class ClosestPoints {
    public ClosestPoints() {
    }
    public  double ClosestPoints(Point points[]  , int n)           //蛮力法
    {
        int index1=0, index2=0;
        double d,minDist = 1000;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i+1; j < n; j++) {
                d= (points[i].getX() - points[j].getX())*(points[i].getX()-points[j].getX())+(points[i].getY()-points[j].getY())*(points[i].getY()-points[j].getY());
                if (d<minDist)
                {
                    minDist =d ;
                    index1 = i;
                    index2 = j ;
                }
            }
        }
       // System.out.print("points="+index1+" points="+index2);
        System.out.print("???????\n"+points[index1].getX()+" "+points[index1].getY()+"\n"+points[index2].getX()+" "+points[index2].getY());
        return minDist;
    }

    public  double ClosestPoints(Point points[] , int low, int high)    //分治
    {
        double d1, d2,d3,d;
        int mid , i , j ,index;
        Point p [] = new Point[points.length];
        if (high - low == 1)
        {
            return Distance(points[low],points[high]);
        }
        if(high - low == 2)
        {
            d1= Distance( points[low],points[high]);    //1,3
            d2= Distance( points[low+1],points[high]);  //2,3
            d3 = Distance(points[low],points[low+1]);   //1,2
            if ((d1<d2)&&(d1<d3))
                {
                        return  d1;
                }
                if (d2<d3)
                    return  d2;
            else  return  d3;
        }
        mid = (low + high)/2;
        d1= ClosestPoints(points,low,mid);
        d2= ClosestPoints(points,mid,high);
        if (d1<d2)
        {
            d=d1;
        }
        else
            d=d2;
        index =0;

        for (i=mid;(i>=low)&&(points[mid].getX()-points[i].getX()<d);i--)
            p[index++]= points[i];
        for (i=mid+1; (i<=high)&&(points[i].getX()-points[mid].getX()<d);i++)
            p[index++]= points[i];
        quicksort(p,0,index-1);
        for (i=0;i<index; i++)
            for (j=i+1;j<index;j++)
            {
                if (p[j].getY()-p[i].getY()>=d)
                    break;
                else
                {
                    d3 = Distance(p[i],p[j]);
                    if (d3<d)
                        d=d3;
                }
            }
            return d;
    }
    static void quicksort(Point n[], int left, int right) {
        int dp;
        if (left < right) {
            dp = partition(n, left, right);
            quicksort(n, left, dp - 1);
            quicksort(n, dp + 1, right);
        }
    }

    static int partition(Point n[], int left, int right) {
        Point pivot = n[left];
        while (left < right) {
            while (left < right && n[right].getY() >= pivot.getY())
                right--;
            if (left < right)
                n[left++] = n[right];
            while (left < right && n[left] .getY()<= pivot.getY())
                left++;
            if (left < right)
                n[right--] = n[left];
        }
        n[left] = pivot;
        return left;
    }
      public  double Distance(Point pointa,Point pointb)
    {

      return Math.sqrt((pointa.getX()-pointb.getX())*(pointa.getX()-pointb.getX())+(pointa.getY()-pointb.getY())*(pointa.getY()-pointb.getY()));

    }
}
