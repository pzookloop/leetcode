package q0713;

public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int ans = 0;
        int left = 0;
        long prod = 1;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) {
                prod /= nums[left];
                left += 1;
            }
            ans += right-left+1;
        }
        return ans;
    }
}
