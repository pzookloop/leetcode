package q0875;

public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        if (h == piles.length) {
            return max;
        }
        // a/b取上整 ==> (a+b-1)/b
        int right = max, left = 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (low(piles, mid, h)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean low(int[] piles, int speed, int h) {
        for (int pile : piles) {
            if (h < 0) return true;
            h -= (speed+pile-1)/speed;
        }
        return h < 0;
    }

    public static void main(String[] args) {
        int[] p = {3,6,7,11};
        int h = 8;
        Solution solution = new Solution();
        System.out.println(solution.minEatingSpeed(p, h));
    }
}
