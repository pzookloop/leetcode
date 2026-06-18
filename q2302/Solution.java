package q2302;

public class Solution {
    public long countSubarrays(int[] nums, long k) {
        long ans = 0;
        long sum = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum * (right-left+1) >= k) {
                sum -= nums[left];
                left += 1;
            }
            ans += right-left+1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        long res = solution.countSubarrays(new int[]{1,1,1}, 5);
        System.out.println(res);
    }
}
