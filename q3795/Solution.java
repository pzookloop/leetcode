package q3795;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minLength(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;
        Map<Integer, Integer> m = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        long sum = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            m.put(nums[right], m.getOrDefault(nums[right], 0)+1);
            if (m.getOrDefault(nums[right], 0) < 2) {
                sum += nums[right];
            } else {
                continue;
            }
            if (sum < k) continue;
            while (m.getOrDefault(nums[left], 0) > 1 || sum - nums[left] >= k) {
                m.put(nums[left], m.getOrDefault(nums[left], 0)-1);
                if (m.getOrDefault(nums[left], 0) == 0) {
                    m.remove(nums[left]);
                    sum -= nums[left];
                }
                left++;
            }
            if (sum >= k) {
                ans = Math.min(ans, right-left+1);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] arr = {57,75,43,52,80,27,18,33,16,75,77,71,10,34};
        int[] arr = {6,6,11};
//        int k = 152;
        int k = 12;
        int res = solution.minLength(arr, k);
        System.out.println(res);
    }
}
