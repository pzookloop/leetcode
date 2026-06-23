package q0034;

import java.util.Arrays;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        // >= target
        int start = lowBound(nums, target);
        if (start == nums.length || nums[start] != target) return new int[]{-1, -1};
        // >= target+1 ==>
        int end = lowBound(nums, target+1);
        if (nums[end-1] != target) return new int[]{-1, -1};
        return new int[]{start, end-1};
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
        int[] nums = {};
        int target = 0;
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.searchRange(nums, target)));
    }
}
