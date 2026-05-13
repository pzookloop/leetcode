package q1658;

public class Solution {
    public int minOperations(int[] nums, int x) {
        int target = -x;
        for (int num : nums) {
            target += num;
        }

        if (target < 0) {
            return -1;
        }

        int n = nums.length;
        int left = 0, sum = 0;
        int ans = -1;

        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (sum > target) {
                sum -= nums[left];
                ++left;
            }
            if (sum == target) {
                ans = Math.max(ans, right-left+1);
            }
        }

        return ans == -1 ? -1 : n - ans;
    }
}
