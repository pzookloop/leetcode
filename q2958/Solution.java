package q2958;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int ans = 0;
        int left = 0;
        Map<Integer, Integer> m = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            m.put(nums[right], m.getOrDefault(nums[right], 0)+1);
            while (m.getOrDefault(nums[right], 0) > k) {
                m.put(nums[left], m.getOrDefault(nums[left], 0)-1);
                left += 1;
            }
            ans = Math.max(ans, right-left+1);
        }
        return ans;
    }
}
