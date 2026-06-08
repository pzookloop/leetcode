package q2397;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private int n = 0;
    private int ans = 0;
    private int curCovRow = 0;
    private static final Map<Integer, Integer> rowSum = new HashMap<>();
    private static final Map<Integer, Boolean> rowCovered = new HashMap<>();
    public int maximumRows(int[][] matrix, int numSelect) {
        n = matrix[0].length;
        List<int[]> matrixList = new ArrayList<>();
        int zeroCol = 0;
        for (int[] ms : matrix) {
            int sum = 0;
            for (int m : ms) {
                sum += m;
            }
            if (sum == 0) {
                zeroCol += 1;
            } else {
                matrixList.add(ms);
            }
        }
        int[][] matrixRemoveZeroRow = matrixList.toArray(new int[matrixList.size()][]);
        for (int i = 0; i < matrixRemoveZeroRow.length; i++) {
            int sum = 0;
            for (int num : matrixRemoveZeroRow[i]) {
                sum += num;
            }
            rowSum.put(i, sum);
            rowCovered.put(i, false);
        }
        dfsInput(matrixRemoveZeroRow, numSelect, 0);
        return ans + zeroCol;
    }

    private void dfsInput(int[][] matrix, int numSelect, int i) {
        if (numSelect == 0 || i >= n) {
            ans = Math.max(ans, curCovRow);
            return;
        }
        dfsInput(matrix, numSelect, i+1);
        int coveredRow = calCovRow(matrix, i);
        curCovRow += coveredRow;
        dfsInput(matrix, numSelect-1, i+1);
        recovery(matrix, i);
        curCovRow -= coveredRow;
    }

    private void dfsOutput(int[][] matrix, int numSelect, int i) {
        if (numSelect == 0) {
            ans = Math.max(ans, curCovRow);
            return;
        }

        for (int j = i; j < n; j++) {
            int coveredRow = calCovRow(matrix, j);
            curCovRow += coveredRow;
            dfsOutput(matrix, numSelect-1, j+1);
            recovery(matrix, j);
            curCovRow -= coveredRow;
        }
    }

    private int calCovRow(int[][] matrix, int col) {
        int coveredRow = 0;
        for (int row = 0; row < matrix.length; row++) {
            Integer rs = rowSum.getOrDefault(row, 0);
            rs -= matrix[row][col];
            rowSum.put(row, rs);
            Boolean isCovered = rowCovered.getOrDefault(row, false);
            if (!isCovered && rs == 0) {
                coveredRow += 1;
                rowCovered.put(row, true);
            }
        }
        return coveredRow;
    }

    private void recovery(int[][] matrix, int col) {
        for (int row = 0; row < matrix.length; row++) {
            Integer rs = rowSum.getOrDefault(row, 0);
            rs += matrix[row][col];
            rowSum.put(row, rs);
            if (rs > 0) {
                rowCovered.put(row, false);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] m = {{0,0,0}, {1,0,1}, {0,1,1},{0,0,1}};
        int t = 2;
        System.out.println(s.maximumRows(m, t));
    }
}
