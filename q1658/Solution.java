package q1658;

public class Solution {
    public int minOperations(int[] nums, int x) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int target = -x;
        for (int num : nums) {
            target += num;
        }
        if (target < 0) return -1;
        if (target == 0) return nums.length;
        int ans = -1;
        int left = 0;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > target) {
                sum -= nums[left];
                left++;
            }
            if (sum == target) {
                ans = Math.max(ans, right-left+1);
                sum -= nums[left];
                left++;
            }
        }
        return ans == -1 ? ans : nums.length-ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] n = {3,2,20,1,1,3};
        int x = 10;
        System.out.println(s.minOperations(n, x));
    }
}
