package algorithms;

/**
 * Created by asus on 2016/11/25.
 */
public class Task_allocationSolves {
    public Task_allocationSolves() {
    }
    public int Task_allocationSolves(int C[][])
    {
        int mincost = 100;
        for (int i = 0 ,cost = 0 ;i<C.length;i++)
        {
            for (int j = 0 ; j<C[0].length;j++)
            {
                if (i!=j) {
                    cost = C[0][i] + C[1][j];
                    if (cost < mincost)
                        mincost = cost;
                }
            }

        }
        return mincost;
    }
}
