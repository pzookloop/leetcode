package q0051;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private final List<List<String>> ans = new ArrayList<>();
    private final Map<Integer, Boolean> vis = new HashMap<>();
    private final Map<Integer, Boolean> prim1 = new HashMap<>();
    private final Map<Integer, Boolean> prim2 = new HashMap<>();
    private int[] cur = null;
    // col[i] 表示第i行的皇后放置于col[i]列
    public List<List<String>> solveNQueens(int n) {
        cur = new int[n];
        dfs(0, n);
        return ans;
    }

    private void dfs(int r, int n) {
        if (r == n) {
            List<String> map = new ArrayList<>();
            StringBuilder builder = new StringBuilder();
            for (int k : cur) {
                builder.repeat(".", n);
                builder.setCharAt(k, 'Q');
                map.add(builder.toString());
                // 清空本轮的数据
                builder.setLength(0);
            }
            ans.add(map);
        }

        for (int c = 0; c < n; c++) {
            if (check(r, c, cur)) {
                vis.put(c, true);
                prim1.put(r+c, true);
                prim2.put(r-c, true);
                cur[r] = c;
                dfs(r+1, n);
                vis.put(c, false);
                prim1.put(r+c, false);
                prim2.put(r-c, false);
            }
        }
    }

    private boolean check(int r, int c, int[] cur) {
        Boolean isVis = vis.getOrDefault(c, false);
        if (isVis) return false;
        Boolean p1Vis = prim1.getOrDefault(r + c, false);
        Boolean p2Vis = prim2.getOrDefault(r - c, false);
        return !p1Vis && !p2Vis;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 4;
        System.out.println(s.solveNQueens(4));
    }
}