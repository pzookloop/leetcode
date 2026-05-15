package q2439;

public class Solution {
    public int minimizeArrayValue(int[] nums) {
        int lBound = 0;
        int rBound = 0;
        for (int num : nums) {
            rBound = Math.max(num, rBound);
        }

        while (lBound <= rBound) {
            int mid = (lBound + rBound) >>> 1;
            if (check(nums, mid)) {
                rBound = mid - 1;
            } else {
                lBound = mid + 1;
            }
        }
        return lBound;
    }

    private boolean check(int[] nums, int limit) {
        long extra = 0;
        for (int i = nums.length-1; i > 0; i--) {
            long  fe = nums[i] + extra;
            if (fe > limit) {
                extra = fe - limit;
            } else {
                extra = 0;
            }
        }

        return (nums[0] + extra) <= (long) limit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {10,1};
        System.out.println(solution.minimizeArrayValue(nums));
    }
}
