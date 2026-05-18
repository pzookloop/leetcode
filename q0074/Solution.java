package q0074;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m*n - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int i = mid/n, j = mid%n;
            if (matrix[i][j] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left == m*n) return false;
        int i = left/n, j = left%n;
        return matrix[i][j] == target;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] m = {{1,3}};
        int t = 2;
        System.out.println(solution.searchMatrix(m, t));
    }
}
