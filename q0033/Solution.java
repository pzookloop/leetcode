package q0033;

public class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n < 2) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0, right = n-2, end = nums[n-1];
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (isRed(target, nums[mid], end)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

    private boolean isRed(int target, int curNum, int end) {
        if (curNum > end) {
            return target <= end || target > curNum;
        } else {
            return target <= end && target > curNum;
        }
    }

    public static void main(String[] args) {
        int[] n = {4,5,6,7,0,1,2};
        int t = 3;
        Solution s = new Solution();
        System.out.println(s.search(n, t));
    }
}
