package algorithms;

/**
 * Created by asus on 2016/12/2.
 */
public class ConvexHull {
    public ConvexHull() {
    }

    public  void ConvexHull(int x[], int y [] , int n)
    {
        int i , j , k ,sign1 ,sign2;
        int A,B,C;
        for (i=0;i<n-1;i++)
            for (j=i+1;j<n;j++)
            {
                sign1 = 0 ;
                sign2 = 0;
                A=y[i] - y[j];
                B = x[j] - x[i];
                C = x[i]* y[j] - x[j]*y[i];
                for (k=0;k<n;k++) {
                    if (k != i && k != j) {
                        if (A * x[k] + B * y[k] + C > 0)
                            sign1 = 1;
                        else
                            sign2 = 1;
                        if (sign1 == sign2)
                            break;
                    }
                }
                    if (k==n)
                    {
                        System.out.print("凸包的线段定点为"+x[i]+" "+y[i]+","+x[j]+" " +y[j]+"\n");
                    }
            }
    }
}
