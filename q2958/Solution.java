package q2958;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int ans = 0;
        int left = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1);
            while (mp.getOrDefault(nums[i], 0) > k) {
                mp.put(nums[left], mp.getOrDefault(nums[left], 0)-1);
                left++;
            }
            ans = Math.max(ans, i-left+1);
        }
        return ans;
    }
}
