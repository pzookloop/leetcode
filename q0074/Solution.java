package q0074;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m*n-1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int row = mid / n;
            int col = mid % n;
            if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left == n*m) return false;
        int row = left / n;
        int col = left % n;
        return matrix[row][col] == target;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] m = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int t = 13;
        System.out.println(solution.searchMatrix(m, t));
    }
}
