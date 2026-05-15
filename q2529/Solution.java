package q2529;

public class Solution {
    public int maximumCount(int[] nums) {
        // < 0 => >= 0
        // > 0 => >= 1
        int neg = low_bound(nums, 0);
        int pos = nums.length - low_bound(nums, 1);
        return Math.max(neg, pos);
    }

    // 左闭右闭, 找到最小的 >= target的nums[i]
    private int low_bound(int[] nums, int target) {
        // [-3 -2 -1 0 1 2] 1
        int left = 0, right = nums.length-1;
        while (left <= right) {
            int mid = left + (right-left) / 2;
            if (nums[mid] < target) {
                // [mid+1, right]
                left = mid+1;
            } else {
                // [left, mid-1]
                right = mid-1;
            }
        }

        // return谁, 谁就不能取等号
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {5,20,66,1314};
        Solution solution = new Solution();
        System.out.println(solution.maximumCount(nums));
    }
}
