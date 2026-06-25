package q162;

public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length < 3) {
            if (nums.length == 2) return nums[0] > nums[1] ? 0 : 1;
            else if (nums.length == 1) return 0;
            else return -1;

        }
        int left = 0, right = nums.length-2;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < nums[mid+1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 1};
        Solution s = new Solution();
        System.out.println(s.findPeakElement(nums));
    }
}
