package q2300;

import java.util.Arrays;

public class Solution {
    // 找到 >= potions[i] 最小的数字, 使得potions[i] * spells[j] >= success
    // target = ceiling(success / spells[j])
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] res = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            long target = (success + spells[i] - 1) / spells[i];
            int left = 0, right = potions.length-1;
            while (left <= right) {
//                int mid = (left + right) >>> 1; // 比 left+(right-left)/2 更快的写法
                int mid = left + (right - left) / 2;
                if (potions[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            res[i] = potions.length - left;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] spells = {3,1,2};
        int[] potions = {8,5,8};
        int success = 16;
        System.out.println(Arrays.toString(solution.successfulPairs(spells, potions, success)));
    }
}
