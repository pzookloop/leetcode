package q2439;

public class Solution {
    public int minimizeArrayValue(int[] nums) {
        int left = Integer.MAX_VALUE, right = 0;
        for (int num : nums) {
            left = Math.min(left, num);
            right = Math.max(right, num);
        }
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (check(nums, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[] nums, int limit) {
        long extra = 0;
        for (int i = nums.length-1; i > 0; --i) {
            if ((nums[i] + extra) <= limit) {
                extra = 0;
                continue;
            }
            extra = (nums[i] + extra) - limit;
        }
        return (extra + nums[0]) <= limit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {10,1};
        System.out.println(solution.minimizeArrayValue(nums));
    }
}
