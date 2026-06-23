package q0275;

public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n-1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int paperNum = n-mid;
            if (citations[mid] < paperNum) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left == n ? 0 : n-left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {0,1};
        System.out.println(solution.hIndex(arr));
    }
}
