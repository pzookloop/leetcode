package q2300;

import java.util.Arrays;

public class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length, m = potions.length;
        if (n == 0 || m == 0) return null;
        int[] pairs = new int[n];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            int sNum = lowBound(potions, spells[i], success);
            pairs[i] = m-sNum;
        }
        return pairs;
    }

    private int lowBound(int[] potions, int spell, long success) {
        int left = 0, right=potions.length-1;
        while (left<=right) {
            int mid = (left + right) >>> 1;
            long power = (long) potions[mid] * spell;
            if (power < success) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] spells = {5,1,3};
        int[] potions = {1,2,3,4,5};
        int success = 7;
        System.out.println(Arrays.toString(solution.successfulPairs(spells, potions, success)));
    }
}
