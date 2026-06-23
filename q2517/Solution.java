package q2517;

import java.util.Arrays;

public class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        // [1, 2, 5, 8, 13, 21]
        int left = 0, right = price[price.length-1] - price[0];
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (f(price, mid, k)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    //定义 f(d)表示甜蜜度至少为 d 时,最多能选多少类糖果. (注意是至少,不是恰好)
    private boolean f(int[] price, int degree, int k) {
        int pre = price[0];
        k--;
        for (int i = 1; i < price.length; i++) {
            if (price[i] >= pre + degree) {
                pre = price[i];
                --k;
            }
        }
        return k <= 0;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] price = {1,3,1};
        int k = 2;
        System.out.println(solution.maximumTastiness(price, k));
    }
}
