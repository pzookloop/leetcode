package q2187;

import java.util.Arrays;

public class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        long left = 1, right = (long)(1e14);
        while (left <= right) {
            long mid = (left + right) >>> 1;
            long canTrips = 0;
            for (int t : time) {
                if (t > mid) break;
                canTrips += mid / t;
            }
            if (canTrips < totalTrips) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] time = {2};
        int totalTrips = 1;
        System.out.println(solution.minimumTime(time, totalTrips));
    }
}
