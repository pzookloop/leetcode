package q0875;

public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long left = 1, right = (long) 1e10;
        int ans = Integer.MAX_VALUE;
        while (left <= right) {
            long mid = (left + right) >>> 1;
            long needTime = 0;
            for (int pile : piles) {
                needTime += (pile + mid - 1) / mid;
            }
            if (needTime > h) {
                left = mid + 1;
            } else {
                right = mid - 1;
                ans = (int) Math.min(ans, mid);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] p = {30,11,23,4,20};
        int h = 6;
        Solution solution = new Solution();
        System.out.println(solution.minEatingSpeed(p, h));
    }
}
