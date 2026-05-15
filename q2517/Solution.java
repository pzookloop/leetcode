package q2517;

import java.util.Arrays;

public class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int n = price.length;
        int lBound = 0, rBound = (price[n-1] - price[0]) / (k-1) + 1;
        while (lBound <= rBound) {
            int mid = (lBound + rBound) >>> 1;
            if (check(price, mid) >= k) {
                lBound = mid + 1;
            } else {
                rBound = mid - 1;
            }
        }
        return lBound-1;
    }

    private int check(int[] price, int mid) {
        // 第一个糖果一定能选择
        int canK = 1;
        int pre = price[0];
        for (int p : price) {
            if (p - pre >= mid) {
                canK += 1;
                pre = p;
            }
        }
        return canK;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] price = {13,5,1,8,21,2};
        int k = 3;
        System.out.println(solution.maximumTastiness(price, k));
    }
}
