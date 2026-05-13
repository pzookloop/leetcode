package q1004;

public class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 1) {
                if (k > 0) {
                    k -= 1;
                } else {
                    while (left < right && nums[left] != 0) {
                        left += 1;
                    }
                    left += 1;
                }
            }
            ans = Math.max(ans, right-left+1);
        }

        return ans;
    }
}
