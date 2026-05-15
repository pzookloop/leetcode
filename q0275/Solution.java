package q0275;

public class Solution {
    public int hIndex(int[] citations) {
        int left = 0, right = citations.length-1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int paperNum = citations.length-mid;
            if (citations[mid] < paperNum) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        if (left >= citations.length) return 0;
        return (citations.length-left) <= citations[left] ? citations.length-left : 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {0,1};
        System.out.println(solution.hIndex(arr));
    }
}
