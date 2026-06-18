package q1004;

public class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                while (k == 0) {
                    if (nums[left] == 0) {
                        k += 1;
                    }
                    left += 1;
                }
                k -= 1;
            }
            ans = Math.max(ans, right-left+1);
        }
        return ans;
    }
}
