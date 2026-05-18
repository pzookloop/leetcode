package q0154;

public class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == nums[right]) {
                right--;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // 因为数组元素可能会重复
                right = mid;
            }
        }


        return nums[left];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {3,1,3};
        System.out.println(s.findMin(nums));
    }
}
