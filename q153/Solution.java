package q153;

public class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int left = 0, right = n-2, end = nums[n-1];
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] > end) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {11,13,15,17};
        Solution s = new Solution();
        System.out.println(s.findMin(nums));
    }
}
