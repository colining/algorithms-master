package algorithms2;

/**
 * Created by asus on 2016/12/2.
 */


    public class CoinSolves {

        public static int compareTo(int[] coins, int[] left, int[] right) {

            int leftTotal = 0;
            int rightTotal = 0;
            int fakeCoin = 0;
            int coinsSize = 0;

            if (coins.length % 2 == 0) {
                coinsSize = coins.length/2;         //�����ڵ�Ӳ�ҷֳ�����
                System.arraycopy(coins, 0, left, 0, coinsSize);     //ǰһ��Ӳ�ҷŵ�left
                for (int i = 0; i < coinsSize; i++) {
                    leftTotal = leftTotal + left[i];        //ǰһ��Ӳ�ҵ�������
                }
                System.arraycopy(coins, coinsSize, right, 0, coinsSize);        //��һ��Ӳ�ҷŵ�right
                for (int j = 0; j < coinsSize; j++) {
                    rightTotal = rightTotal + right[j];         //��һ��Ӳ�ҵ�������
                }
            }
            //�Ƚ�right��left���ߵ�Ӳ������
            if (leftTotal < rightTotal && coinsSize != 1) {
                coins = right;
                int[] right_1 = new int[coinsSize/2];
                int[] left_1 = new int[coinsSize/2];
                right = right_1;        //��̬�ı������С�����κ�Ӳ�Ҽ���
                left = left_1;
                System.arraycopy(coins, 0, left, 0, coinsSize/2);
                System.arraycopy(coins, coinsSize/2, right, 0, coinsSize/2);
            } else if (leftTotal > rightTotal && coinsSize != 1) {
                coins = left;
                int[] right_1 = new int[coinsSize/2];
                int[] left_1 = new int[coinsSize/2];
                right = right_1;
                left = left_1;
                System.arraycopy(coins, 0, left, 0, coinsSize/2);
                System.arraycopy(coins, coinsSize/2, right, 0, coinsSize/2);
            }
            if (left.length != 1 && right.length != 1 && fakeCoin == 0) {
                fakeCoin = compareTo(coins, left, right);    //�ݹ���ã�������fakeCoin=�����շ��ػ�Ϊ0
            }
            if (left.length == 1 && right.length == 1 && coinsSize == 2) {
                if (left[0] < right[0]) {
                    fakeCoin = right[0];
                } else if (left[0] == right[0]){
                    System.out.println(left[0] + "and" + right[0]);
                } else {
                    fakeCoin = left[0];
                }
            }
            return fakeCoin;
        }
    }
