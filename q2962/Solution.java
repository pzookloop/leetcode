package q2962;

public class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        long ans = 0;
        int currentOcc = 0, left = 0;
        for (int num : nums) {
            if (num == max) {
                currentOcc += 1;
            }
            while (currentOcc >= k) {
                if (nums[left] == max) {
                    currentOcc -= 1;
                }
                left += 1;
            }
            // 从0到left-1都是有效的以right为右边界数组的子数组
            ans += left;
        }

        return ans;
    }
}
