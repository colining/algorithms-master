package algorithms;

/**
 * Created by asus on 2016/11/25.
 */
public class KnapsackSolves {
    public int[] DecimaltoBinary(int n,int m)
    {
        int r;//求余数
        int consult=1;//求商
        int j = 0;
        int []arr=new int[m];
        while (consult!=0)
        {
            consult = n / 2;
            r = n % 2;
            n = consult;
            arr[j] = r;
            j++;
        }
        return arr;
    }
    /**
     * 将求得的一位数组子集转换为二维数组
     * @param m
     * @return
     */
    public int[][] Subset(int m)
    {
        KnapsackSolves s=new KnapsackSolves();
        int subset[][]=new int[(int) Math.pow(2, m)][m];
        for (int i = 0; i <Math.pow(2, m); i++)
        {
            for (int j =0; j<m; j++)
            {
                subset[i][j]=s.DecimaltoBinary(i,m)[j];
            }
        }
        return subset;

    }
    public int MaxValue(int arr[])
    {
        int max = arr[0];
        for (int in = 0 ; in < arr.length; in++)
        {
            if( arr[in] > max)
            {
                max = arr[in];
            }
        }
        return max;

    }
}
