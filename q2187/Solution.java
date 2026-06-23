package q2187;

public class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int fast = Integer.MAX_VALUE, slow = Integer.MIN_VALUE;
        for (int t : time) {
            fast = Math.min(fast, t);
            slow = Math.max(slow, t);
        }
        int n = time.length;
        int round = (totalTrips+n-1)/n;
        long right = (long) round * slow;
        long left = (long) round * fast;
        while (left <= right) {
            long mid = (left + right) >>> 1;
            if (check(time, mid, totalTrips)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean check(int[] time, long totalTime, int totalTrips) {
        long realTrips = 0;
        for (int t : time) {
            realTrips += totalTime / t;
        }
        return realTrips < totalTrips;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] time = {1,2,3};
        int totalTrips = 5;
        System.out.println(solution.minimumTime(time, totalTrips));
    }
}
