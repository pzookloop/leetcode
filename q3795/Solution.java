package q3795;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minLength(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        int left = 0;
        long subArrSum = 0;
        for (int right = 0; right < n; right++) {
//            int curNum = nums[right];
//            if (curNum == 77) {
//                System.out.println(curNum);
//            }
            Integer curOccCnt = mp.getOrDefault(nums[right], 0);
            curOccCnt += 1;
            mp.put(nums[right], curOccCnt);
            if (curOccCnt < 2) {
                subArrSum += nums[right];
            }
            if (subArrSum < k) {
                continue;
            }
            while (subArrSum - nums[left] >= k || mp.getOrDefault(nums[left], 0) > 1) {
                Integer leftOccCnt = mp.getOrDefault(nums[left], 0);
                if (leftOccCnt < 2) {
                    subArrSum -= nums[left];
                }
                mp.put(nums[left], leftOccCnt-1);
                ++left;
            }
            ans = Math.min(ans, right-left+1);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {57,75,43,52,80,27,18,33,16,75,77,71,10,34};
        int k = 152;
        int res = solution.minLength(arr, k);
        System.out.println(res);
    }
}
