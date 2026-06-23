package q2563;

import java.util.Arrays;

public class Solution {
//    public long countFairPairs(int[] nums, int lower, int upper) {
//        Arrays.sort(nums);
//        long ans = 0;
//        // (1)lower-nums[j] <= nums[i] ==> 找到 >= lower-nums[j]的最小nums[i]的下标
//        // upper-nums[j] >= nums[i] ==> nums[i] < upper-nums[j]+1 ==>
//        // 找到 >= upper-nums[j]+1的最小nums[i]的下标
//        // (2) nums[j]是固定选项, 所以需要在[0,j-1]之间二分nums[i]
//        for (int j = 0; j < nums.length; ++j) {
//            int a = low_bound(nums, lower-nums[j], j-1);
//            int b = low_bound(nums, upper-nums[j]+1, j-1);
//            ans += b-a;
//        }
//        return ans;
//    }

//    private int low_bound(int[] nums, int target, int right) {
//        int left = 0;
//        while (left <= right) {
//            int mid = (left + right) >>> 1;
//            if (nums[mid] < target) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//        return left;
//    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        if (n == 0) return 0;
        Arrays.sort(nums);
        long ans = 0;
        // l<=a+b<=u ==>  l-b<=a<=u-b ==> a<=u-b ==> a<u-b+1 ==> x>=u-b+1
        for (int right = 0; right < nums.length; right++) {
            int l = lowBound(nums, lower-nums[right], right-1);
            int r = lowBound(nums, upper-nums[right]+1, right-1);
            ans += r-l;
        }
        return ans;
    }

    private int lowBound(int[] nums, int target, int right) {
        int left = 0;
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

}
