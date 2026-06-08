package q2212;

import java.util.Arrays;

public class Solution {
    private final int[] ans = new int[12];
    private final int[] curArr = new int[12];
    private int maxAns = 0;
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        dfsInput(numArrows, aliceArrows, 1);
        return ans;
    }

    private void dfsInput(int numArrows, int[] aliceArrows, int i) {
        if (i == 12) {
            getMaxScore(numArrows);
            return;
        }
        dfsInput(numArrows, aliceArrows, i+1);
        if (numArrows > aliceArrows[i]) {
            int need = aliceArrows[i] + 1;
            curArr[i] = need;
            dfsInput(numArrows-need, aliceArrows, i+1);
            curArr[i] = 0;
        }

    }

    private void getMaxScore(int numArrows) {
        int sum = 0;
        for (int m = 0; m < 12; m++) {
            if (curArr[m] > 0) {
                sum += m;
            }
        }
        if (maxAns < sum) {
            maxAns = sum;
            System.arraycopy(curArr, 0, ans, 0, 12);
            ans[0] += numArrows;
        }
    }

    private void dfsOutput(int numArrows, int[] aliceArrows, int i) {
        getMaxScore(numArrows);
        if (i >= 12) {
            return;
        }

        for (int j = i; j < 12; ++j) {
            int need = aliceArrows[j] + 1;
            if (numArrows >= need) {
                curArr[j] = need;
                dfsOutput(numArrows-need, aliceArrows, j+1);
                curArr[j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] aliceArrows = {0,0,0,0,0,0,0,0,0,0,0,100000};
        int numArrows = 100000;
        System.out.println(Arrays.toString(s.maximumBobPoints(numArrows, aliceArrows)));
    }
}
