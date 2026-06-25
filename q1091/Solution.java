package q1091;

import java.util.Arrays;

public class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int left = 0, right = rows*cols-1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int row = mid / cols;
            int max = 0, curCol = 0;
            for (int i = 0; i < cols; i++) {
                if (mat[row][i] > max) {
                    max = mat[row][i];
                    curCol = i;
                }
                max = Math.max(max, mat[row][i]);
            }
            int topV = row-1 >= 0 ? mat[row-1][curCol] : -1;
            int bottomV = row+1 < rows ? mat[row+1][curCol] : -1;
            if (max > topV && max > bottomV) {
                return new int[]{row, curCol};
            } else if (max < bottomV) {
                left = mid + 1;
            } else {
                right = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] mat = {
                {10,20,15},
                {21,30,14},
                {7,16,32}
        };
        System.out.println(Arrays.toString(s.findPeakGrid(mat)));
    }


}
