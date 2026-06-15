package q0052;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Integer ans = 0;
    private final Map<Integer, Boolean> vis = new HashMap<>();
    private final Map<Integer, Boolean> prim1 = new HashMap<>();
    private final Map<Integer, Boolean> prim2 = new HashMap<>();
    public int totalNQueens(int n) {
        dfs(0, n);
        return ans;
    }

    private void dfs(int r, int n) {
        if (r == n) {
            ans += 1;
            return;
        }
        for (int c = 0; c < n; c++) {
            if (check(r, c)) {
                prim1.put(r+c, true);
                prim2.put(r-c, true);
                vis.put(c, true);
                dfs(r+1, n);
                prim1.put(r+c, false);
                prim2.put(r-c, false);
                vis.put(c, false);
            }
        }
    }

    private boolean check(int r, int c) {
        Boolean isVis = vis.getOrDefault(c, false);
        if (isVis) return false;
        Boolean leftVis = prim1.getOrDefault(r + c, false);
        Boolean rightVis = prim2.getOrDefault(r - c, false);
        return !leftVis && !rightVis;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 1;
        System.out.println(s.totalNQueens(n));
    }
}
