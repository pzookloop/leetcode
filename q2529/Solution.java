package q2529;

public class Solution {
    public int maximumCount(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        // >= 0
        int neg = lowBound(nums, 0);
        // >= 1
        int pos = lowBound(nums, 1);
        return Math.max(neg, n-pos);
    }

    private int lowBound(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {-3,-2,-1,0,0,1,2};
        Solution solution = new Solution();
        System.out.println(solution.maximumCount(nums));
    }
}
