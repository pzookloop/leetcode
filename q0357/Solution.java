package q0357;

public class Solution {
    private int ans = 0;
    private final int[] vis = new int[10];
    public int countNumbersWithUniqueDigits(int n) {
        for (int len = 0; len <= n; ++len) {
            dfs(0, len);
        }
        return ans;
    }

    private void dfs(int pos, int len) {
        if (pos == len) {
            ans += 1;
            return;
        }
        int start = pos == 0 ? 1 : 0;
        for (int j = start; j < 10; ++j) {
            if (vis[j] == 0) {
                vis[j] = 1;
                dfs(pos+1, len);
                vis[j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 2;
        System.out.println(s.countNumbersWithUniqueDigits(n));
    }
}
