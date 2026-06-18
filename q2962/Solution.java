package q2962;

public class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxV = 0;
        for (int num : nums) {
            maxV = Math.max(maxV, num);
        }
        long ans = 0;
        int left = 0;
        int occ = 0;
        for (int num : nums) {
            if (num == maxV) {
                occ += 1;
            }
            while (occ >= k) {
                if (nums[left] == maxV) {
                    occ--;
                }
                left++;
            }
            ans += left;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] n = {1,3,2,3,3};
        int k = 2;
        Solution s = new Solution();
        System.out.println(s.countSubarrays(n, k));
    }
}
