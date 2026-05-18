package q1091;

import java.util.Arrays;

public class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int left = 0, right = n-1;
        while (left <= right) {
            int midCol = (left + right) >>> 1;
            int maxRow = 0;
            for (int i = 0; i < m; ++i) {
                if (mat[i][midCol] > mat[maxRow][midCol]) {
                    maxRow = i;
                }
            }
            int colMax = mat[maxRow][midCol];
            int leftNg = midCol-1 > 0 ? mat[maxRow][midCol-1] : -1;
            int rightNg = midCol+1 < n ? mat[maxRow][midCol+1] : -1;
            if (colMax > Math.max(leftNg, rightNg)) {
                return new int[]{maxRow, midCol};
            }
            if (colMax < leftNg) right = midCol-1;
            else left = midCol+1;
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] mat = {
                {1,10},
                {50,500},
                {40,2},
                {30,3},
                {20,4}
        };
        System.out.println(Arrays.toString(s.findPeakGrid(mat)));
    }


}
