package q2302;

public class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        int left = 0;
        long ans = 0;

        long[] preSum = new long[n];
        for (int right = 0; right < nums.length; right++) {
            preSum[right] = right > 0 ? nums[right] + preSum[right-1] : nums[0];
            long score = (preSum[right]-preSum[left]+nums[left])*(right-left+1);
            while (left < right && score >= k) {
                left += 1;
                score = (preSum[right]-preSum[left]+nums[left]) * (right-left+1);
            }

            ans += left < right ? right-left+1 : (nums[left] < k ? 1 : 0); // 5 6 7 8
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        long res = solution.countSubarrays(new int[]{10,10,10}, 5);
        System.out.println(res);
    }
}
